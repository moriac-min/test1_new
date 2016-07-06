package common.commonfacillity.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public abstract class CommonAbstractBaseService extends AbstractServiceImpl{
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
}
