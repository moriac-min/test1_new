var jsSlider = function() {
	this.options = { };
	this.$layout = null;
	this.$layer = null;
	this.$items = null;
	this.showIndex = -1;
	this.isRun = false;
	this.isPlay = false;
	this.playmode = 1; //0:prev 1:next
	this.init = function(_options) {
		this.options = $.extend({
			interval : 3000,
			autoStart : true,
			layout : '',
			layer : 'ul',
			item : 'li',
			margin : 0,
			prevButton : '',
			nextButton : '',
			playButton : '',
			pauseButton : '',
			visible : 1,
			step : 1,
			mouseOverPause : false,
			mode : 'vertical'
		}, _options || {});

		this.$layout = $('#' + this.options.layout);
		this.$layer = this.$layout.find('>' + this.options.layer);
		this.$items = this.$layout.find('>' + this.options.layer + '>' + this.options.item);
		this.isPlay = this.options.autoStart;

		this.initButtons();

		this.initItemsPosition();

		this.initItemsEvent();

		if (this.$items.size() > 0 && this.options.autoStart) {
			this.start();
		}
	};
	this.initItemsPosition = function() {
		var _self = this;
		/*this.$items.each(function(index) {
			if (index < _self.options.visible)
				$(this).css(_self.options.mode == 'vertical' ? 'top' : 'left', (_self.options.mode == 'vertical' ? $(this).height() * index : $(this).width() * index) + (_self.options.margin * index));
			else
				$(this).css(_self.options.mode == 'vertical' ? 'top' : 'left', (_self.options.mode == 'vertical' ? $(this).height() * _self.options.visible : $(this).width() * _self.options.visible) + (_self.options.margin * index));
		});*/
		this.on(0);
	};
	this.initItemsEvent = function() {
		var _self = this;
		this.$items.each(function(index) {
			$(this).bind('focusin', function() {
				_self.stop();
				_self.on(index);
			});
			$(this).bind('focusout', function() {
				if (_self.isPlay) _self.start();
			});
		});
		if (this.options.mouseOverPause) {
			this.$items.each(function(index) {
				$(this).bind('mouseover', function() {
					_self.stop();
					//_self.on(index);
				});
			});
			this.$items.each(function(index) {
				$(this).bind('mouseout', function() {
					if (_self.isPlay) _self.start();
				});
			});
		}
	};
	this.prev = function() {
		this.playmode = 0;
		var to = this.showIndex - this.options.step;
		if (to < 0) to += this.$items.size();
		this.go(to);
	};
	this.next = function() {
		this.playmode = 1;
		var to = this.showIndex + this.options.step;
		if (to > this.$items.size() - 1) to -= this.$items.size();
		this.go(to);
	};
	this.initButtons = function() {
		var _self = this;
		if (this.options.prevButton != '' && !this.isUndefined($('#' + this.options.prevButton))) {
			$('#' + this.options.prevButton).bind('click', function() {
				_self.prev();
				_self.isPlay = true;
				_self.start();
				return false;
			});
		}
		if (this.options.nextButton != '' && !this.isUndefined($('#' + this.options.nextButton))) {
			$('#' + this.options.nextButton).bind('click', function() {
				_self.next();
				_self.isPlay = true;
				_self.start();
				return false;
			});
		}
		if (this.options.playButton != '' && !this.isUndefined($('#' + this.options.playButton))) {
			$('#' + this.options.playButton).bind('click', function() {
				_self.isPlay = true;
				_self.start();
				return false;
			});
		}
		if (this.options.pauseButton != '' && !this.isUndefined($('#' + this.options.pauseButton))) {
			$('#' + this.options.pauseButton).bind('click', function() {
				_self.isPlay = false;
				_self.stop();
				return false;
			});
		}
	};
	//off, focusout
	this.start = function() {
		var _self = this;
		this.stop();
		var func = function() {
			//_self.stop();
			var to = _self.showIndex;
			if (_self.playmode == 1)
				to += _self.options.step;
			else
				to -= _self.options.step;
			if (to > _self.$items.size() - 1) to -= _self.$items.size();
			if (to < 0) to += _self.$items.size();
			_self.go(to);
		};
		this.intervalFunction = window.setInterval(func, this.options.interval);
	};
	//on, focusin
	this.stop = function() {
		//this.isPlay = false;
		if (!this.isUndefined(this.intervalFunction)) window.clearInterval(this.intervalFunction);
	};
	this.on = function(index) {
		if (this.showIndex > 0 && index >= this.showIndex && index <= this.showIndex + (this.options.visible - 1)) return false;
		this.showIndex = index;
		this.$items.css(this.options.mode == 'vertical' ? 'top' : 'left', -1 * ((this.options.mode == 'vertical' ? this.$items.eq(index).height() : this.$items.eq(index).width()) + this.options.margin));
		this.$items.eq(index).css(this.options.mode == 'vertical' ? 'top' : 'left', 0);
		if (this.options.visible > 1) {
			for (var i = 1; i < this.options.visible; i++) {
				var visibleIndex = index + i;
				if (visibleIndex > this.$items.size() - 1) visibleIndex -= this.$items.size();
				this.$items.eq(visibleIndex).css(this.options.mode == 'vertical' ? 'top' : 'left', ((this.options.mode == 'vertical' ? this.$items.eq(visibleIndex).height() : this.$items.eq(visibleIndex).width()) + this.options.margin) * i);
			}
		}
	};
	//
	this.go = function(to) {
		if (this.isRun) return;
		if (this.showIndex == to) return;
		if (to < 0 || to > this.$items.size() - 1) return;

		var _self = this;

		this.isRun = true;
		this.showIndex = to;

		var moveIndexList = new Array;
		if (this.playmode == 1) {
			var prevIndex = to - this.options.step;
			//화면에 보여지는 것들
			for (var i = 0; i < this.options.visible; i++) {
				var visibleIndex = prevIndex + i;
				if (visibleIndex > this.$items.size() - 1) visibleIndex -= this.$items.size();
				moveIndexList.push(visibleIndex);
			}
			//화면에 보여져야 할 것들
			for (var i = 0; i < this.options.step; i++) {
				var visibleIndex = prevIndex + this.options.visible + i;
				if (visibleIndex > this.$items.size() - 1) visibleIndex -= this.$items.size();
				this.$items.eq(visibleIndex).css(this.options.mode == 'vertical' ? 'top' : 'left', ((this.options.mode == 'vertical' ? this.$items.eq(visibleIndex).height() : this.$items.eq(visibleIndex).width()) + this.options.margin) * i + (this.options.mode == 'vertical' ? this.$layout.height() : this.$layout.width()));
				moveIndexList.push(visibleIndex);
			}
		} else {
			var prevIndex = to + this.options.step;
			//화면에 보여지는 것들
			for (var i = this.options.visible - 1; i >= 0; i--) {
				var visibleIndex = prevIndex + i;
				if (visibleIndex > this.$items.size() - 1) visibleIndex -= this.$items.size();
				moveIndexList.push(visibleIndex);
			}
			//화면에 보여져야 할 것들
			for (var i = this.options.step - 1; i >= 0; i--) {
				var visibleIndex = to + i;
				if (visibleIndex > this.$items.size() - 1) visibleIndex -= this.$items.size();
				this.$items.eq(visibleIndex).css(this.options.mode == 'vertical' ? 'top' : 'left', ((this.options.mode == 'vertical' ? this.$items.eq(visibleIndex).height() : this.$items.eq(visibleIndex).width()) + this.options.margin) * (this.options.step - i) * -1);
				moveIndexList.push(visibleIndex);
			}
		}

		if (moveIndexList.length > 0) {
			for (var i = 0; i < moveIndexList.length; i++) {
				if (!this.isUndefined(this.$items.eq(moveIndexList[i]))) {
					if (i == moveIndexList.length - 1) {
						this.move(moveIndexList[i], ((this.options.mode == 'vertical' ? this.$items.eq(moveIndexList[i]).height() : this.$items.eq(moveIndexList[i]).width()) + this.options.margin) * this.options.step, function() { _self.isRun = false; });
					} else {
						this.move(moveIndexList[i], ((this.options.mode == 'vertical' ? this.$items.eq(moveIndexList[i]).height() : this.$items.eq(moveIndexList[i]).width()) + this.options.margin) * this.options.step);
					}
				}
			}
		}
	};
	//animate
	this.move = function(index, distance, complete) {
		var _self = this;

		var direction = '+';
		if (this.playmode == 1) direction = '-';
		if (this.options.mode == 'vertical') {
			this.$items.eq(index).animate({
				"top": direction + "=" + distance + "px"
			},
			500,
			function() {
				if (!_self.isUndefined(complete)) {
					complete();
				}
			});
		} else if (this.options.mode == 'horizontal') {
			this.$items.eq(index).animate({
				"left": direction + "=" + distance + "px"
			},
			500,
			function() {
				if (!_self.isUndefined(complete)) {
					complete();
				}
			});
		}
	};
	//
	this.isUndefined = function(_obj) {
		if (typeof _obj == 'undefined') return true;
		else return false;
	};
};