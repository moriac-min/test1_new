<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
    <nav id="left-nav" class="left-nav"> 
        <!-- 메뉴 컨텐츠 -->
        <div id="left_front_contents">
        	<!-- 레프트메뉴 들어갈 공간 -->
        </div>
        	
            <div class="addon">
            
            	<c:if test="${sys_dvs_cd == 'SITE01' && menu_grp == 'MENU_GRP02'}">
                <ul>
					<li><a href="#" class="bmi">BMI계산기</a></li>
                    <li><a href="#" class="cal">운동칼로리계산기</a></li>
                    <li><a href="#" class="nutri">영양성분표 산출</a></li>
                    <li><a href="#" class="food">외식영양성분자료집</a></li>
                </ul>
                </c:if>
                
                <c:if test="${sys_dvs_cd == 'SITE01' || sys_dvs_cd == 'SITE02'}">
                <h2>확인해보세요</h2>
                <ul>
                    <li><a href="#" class="poison">식중독지수</a></li>
                </ul>
                </c:if> 
            </div>
            <c:if test="${sys_dvs_cd == 'SITE01' || sys_dvs_cd == 'SITE02'}">
            <div class="newsletter">
                <h2>뉴스레터 이메일로 받아보세요</h2>
                <fieldset>
                <legend>뉴스레터 이메일 등록</legend>
                <input id="email" name="email" onfocus="if(this.value !='')this.value='';" onblur="if(this.value.length==0){this.value='';}" value="">
                <input id="agree" name="agree" type="checkbox" value="yes"> <label for="agree"><span>개인정보 활용에 동의합니다.</span></label>
                <input type='button' value='뉴스레터 메일링서비스 신청' onclick="fncSubmit()" class="btn btn-default">
                </fieldset>
            </div>
            </c:if>
            <div id="left-banner1" class="left-banner">
                <a href="#"><img src="${contextPath}/img/common/banner-stat.png" width="184" height="156" alt="지역별식품안전현황 : 우리지역 식품안전 현황을 살펴보세요"></a>
            </div>
        </nav>
        
    <script type="text/javascript">
    
    // 반응형 좌측메뉴 슬라이드
    function setLeftActive(){
        $("#lnb").navgoco({
            caretHtml: '',
            accordion: true,
            openClass: 'open',
            save: true,
            cookie: {
                name: 'navgoco',
                expires: false,
                path: '/'
            },
            slide: {
                duration: 400,
                easing: 'swing'
            },
            // Add Active class to clicked menu item
            onClickAfter: function(e, submenu) {
                e.preventDefault();
                $('#lnb').find('li').removeClass('active');
                var li =  $(this).parent();
                var lis = li.parents('li');
                li.addClass('active');
                lis.addClass('active');
                
                var location = $(this).attr('href');
                window.location=location;
            },
        });
    }
    
       
	
        var menuStr = "";
        var data = new Array();
	    //메뉴다시그리기 
	    function setLeftMenuTree(leftList){
	        data = leftList;
	        
	        $("#left_front_contents").html("");
	        menuStr = "";
	        
	        if(data != null){
	            if(data.length > 0){
	                var start = 0;
	                var lv2 = 0;
	                var lv3 = 0;
	                var lv4 = 0;
	                
	                for(var i=0; i<data.length; i++){
	                	
	                    if(data[i].lv == "1"){     //1레벨
	                        menuStr += "<h2>"+data[i].menu_nm+"</h2>\n";   
	                        if(start == 0){
	                            menuStr += "<ul id='lnb' class='lnb'>\n";
	                        }
	                        start++;
	                    }
	                    
	                    if(data[i].lv == "2"){     //2레벨
	                    	if(data[i].menu_type_cd == 'MENU03'){
	                    		menuStr += "  <li id='menu_li_"+data[i].menu_no+"'><a href='"+data[i].url+"' target=\"_blank\">"+data[i].menu_nm+"</a>\n";
	                    	}else{
	                    		menuStr += "  <li id='menu_li_"+data[i].menu_no+"'><a href='#' onclick='javascript:moveMenu("+i+")'>"+data[i].menu_nm+"</a>\n";
	                    	}
	                        lv2++;
	                    }
	                    if(data[i].lv == "3"){     //3레벨
                    		if(lv3 < 1){
                    			menuStr += "    <ul>\n";
                    		}
	                        
                    		if(data[i].menu_type_cd == 'MENU03'){
	                    		menuStr += "  <li id='menu_li_"+data[i].menu_no+"'><a href='"+data[i].url+"' target='_blank'>";
	                    	}else{
	                    		menuStr += "  <li id='menu_li_"+data[i].menu_no+"'><a href='#' onclick='javascript:moveMenu("+i+")'>";
	                    	}
	                        
	                        /* api 메뉴로 진입시 레프트메뉴명 왼쪽에 아이콘 붙음 */
	                        if(menuGrp == 'MENU_GRP31' || data[i].menu_nm == 'SHEET'){
	                        	 menuStr += "<i class='label label-primary'>S</i> &nbsp;";
	                        }else if(menuGrp == 'MENU_GRP31' || data[i].menu_nm == 'CHART'){
	                        	 menuStr += "<i class='label label-success'>C</i> &nbsp;";
	                        }else if(menuGrp == 'MENU_GRP31' || data[i].menu_nm == 'FILE'){
	                        	 menuStr += "<i class='label label-info'>F</i> &nbsp;";
	                        }else if(menuGrp == 'MENU_GRP31' || data[i].menu_nm == 'MAP'){
	                        	 menuStr += "<i class='label label-default'>M</i> &nbsp;";
	                        }else if(menuGrp == 'MENU_GRP31' || data[i].menu_nm == 'LINK'){
	                        	 menuStr += "<i class='label label-warning'>L</i> &nbsp;";
	                        }else if(menuGrp == 'MENU_GRP31' || data[i].menu_nm == 'OPEN API'){
	                        	 menuStr += "<i class='label label-danger'>O</i> &nbsp;";
	                        }
	                        /* ===================================== */
	                        
	                        menuStr += data[i].menu_nm;
	                        menuStr += "</a>\n";
	                        lv3++;
	                    }
	                    
	                    
	                    if(data[i].lv == "4"){     //4레벨
	                        if(lv4 < 1){
	                            menuStr += "        <ul>\n";
	                        }    
	                        if(data[i].menu_type_cd == 'MENU03'){
	                    		menuStr += "  <li id='menu_li_"+data[i].menu_no+"'><a href='"+data[i].url+"' target='_blank'>"+data[i].menu_nm+"</a></li>\n";
	                    	}else{
	                    		menuStr += "  <li id='menu_li_"+data[i].menu_no+"'><a href='#' onclick='javascript:moveMenu("+i+")'>"+data[i].menu_nm+"</a></li>\n";
	                    	}
	                        lv4++;
	                    }
	                    
	                  //4단계 닫기
	                    if(lv4 > 0 && i+1 <= data.length){
	                    	if(data[i+1].lv == '1' || data[i+1].lv == '2' || data[i+1].lv == '3'){                   
	 	                        menuStr += "    </ul>\n";
	 	                        lv4 = 0;
	 	                    }
	                    }
	                    
	                    //3단계 닫기
	                    if(lv3 > 0 && i+1 < data.length){
	                    	if(data[i+1].lv == '1' || data[i+1].lv == '2'){                   
	                    		menuStr += "   </li>\n";
	                    		menuStr += "    </ul>\n";
	 	                        lv3 = 0;
	 	                    }
	                    }
	                   
	                    if(lv2 > 0 && i+1 < data.length){
	                    	if(data[i+1].lv == '1'){   
	                    		menuStr += "   </li>\n";
	 	                        menuStr += "    </ul>\n";
	 	                        lv2 = 0;
	 	                    }
	                    }
	                    //1단계 닫기
	                    if(start > 0 && i == data.length-1){
	                        menuStr += "</ul>\n";
	                        start = 0;
	                    }
	                }
	                
	                
	              $("#left_front_contents").html(menuStr);
	              setLeftActive();
	            }
	        }
		    $("#menu_li_${menu_no}").addClass("active");
	    }   
         
	    function moveMenu(index){
	    	 
	    	var sitePath;
	    	if('${sys_dvs_cd}' == 'SITE01')		{	sitePath = '/portal';}
	    	else if('${sys_dvs_cd}' == 'SITE02'){	sitePath = '/minwon';}
	    	else if('${sys_dvs_cd}' == 'SITE03'){	sitePath = '/api';	}
	    	else if('${sys_dvs_cd}' == 'SITE04'){	sitePath = '/csm';	}
	    	 
	    	var baseBbsUrl = sitePath+"/board/board.do";    //게시판 기본 url
	    	var menu_no = data[index].menu_no;
	    	var menu_type_cd = data[index].menu_type_cd;
	    	var url = "";
	    	 
	    	if(menu_type_cd != "MENU01"){
		     	if(menu_type_cd == "MENU03"){    //링크메뉴
		    		 //window.open(optionalArg1, optionalArg2, optionalArg3, optionalArg4)
		    		alert('링크작업중');
		    	}else{
		    		if(menu_type_cd == "MENU02"){   //일반메뉴
		    			url = data[index].url;
		    		}else if(menu_type_cd == "MENU04"){   //게시판메뉴
				    	
		    			url = baseBbsUrl;
		    			
		    		}
		    		 
		    		var checkGetUrl = url.split("?");
		    		if(checkGetUrl.length < 2){
		    			$("#menu_grp").val('${menu_grp}');    //gnb.jsp 에 있는 menu_grp 변수
	                    $("#menu_no").val(menu_no);
	                    document.baseForm.action="${contextPath}"+url;
	                    document.baseForm.target="_self";
	                    document.baseForm.submit();
		    		}else{
	                    location.href="${contextPath}"+url+"&menu_no="+menu_no+"&menu_grp="+'${menu_grp}';
		    		}
		    		
		    	}
	    	}
	    }
	     
	     var menu_grp_data = new Array();	 	
	     function setLeftMenu(value){
	    	var leftUrl;
	    	if('${sys_dvs_cd}' == 'SITE01')		{	leftUrl = '/portal/left.do';}
	    	else if('${sys_dvs_cd}' == 'SITE02'){	leftUrl = '/minwon/left.do';}
	    	else if('${sys_dvs_cd}' == 'SITE03'){	leftUrl = '/api/left.do';	}
	    	else if('${sys_dvs_cd}' == 'SITE04'){	leftUrl = '/csm/left.do';	}
	    	$.ajax({ 
	            data: {menu_no : '${menu_no}'
	            	  ,menu_grp : '${menu_grp}'
	            	  ,sys_dvs_cd : '${sys_dvs_cd}'},
	            dataType:'json', 
	            type:'POST',
	            url:"${contextPath}"+leftUrl, 
	            success:function(leftList){         	   	
	            	setLeftMenuTree(leftList);
	            },
	            error:function(request,status,error){
	                alert("실패코드 : " + request.status+"\n메세지 : " + request.error);
	            }
	        });	
	 	}
	     
	    setLeftMenu();
	   
    </script>
    