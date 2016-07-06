package common.adminfacillity.commonmngt.service.impl;

import java.util.Arrays;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.castor.core.util.Base64Decoder;
import org.castor.core.util.Base64Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.cryptography.EgovCryptoService;
import egovframework.rte.fdl.property.EgovPropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.adminfacillity.commonmngt.mapper.LoginMapper;
import common.adminfacillity.commonmngt.service.LoginService;
import common.adminfacillity.commonmngt.service.LoginVO;

@Service("comcmService")
public class LoginServiceImpl extends AbstractServiceImpl implements LoginService{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	EgovPropertyService propertiesService;
	
	@Resource(name = "ARIACryptoService")
	EgovCryptoService crytoService;
	
	/* (non-Javadoc)
	 * @see egovframework.com.cm.service.ComcmService#selectLogin(int)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly=true)
	public int selectLogin(LoginVO vo) throws Exception{
		HashMap map = new HashMap<String, String>();
		int vResult = -1;
		try{
			String vPropPassword = propertiesService.getString("com.aria.password");
//			log.debug("ORIGIN            ::: " + vo.getPassword());
//			log.debug("vPropPassword     ::: " + vPropPassword);
			
			byte[] encrypt = crytoService.encrypt(vo.getPassword().getBytes("UTF-8"),vPropPassword);
			byte[] decrypt = crytoService.decrypt(encrypt,vPropPassword);
			String dePw = new String(decrypt, "UTF-8");
//			log.debug("ENCRPTO Password  ::: " + encrypt);
//			log.debug("DECRPTO Password  ::: " + dePw);
			
			String ecoding = Base64.encodeBase64String(encrypt);
//			byte[] decoding = Base64.decodeBase64(ecoding);
//			log.debug("BASE64 ENCODING   ::: " + ecoding);
//			log.debug("BASE64 DECODING   ::: " + decoding);
//			byte[] decrypt2 = crytoService.decrypt(decoding,vPropPassword);
//			log.debug("BASE64 DECODING2  ::: " + new String(decrypt2, "UTF-8"));
			
			map.put("sabun", vo.getSabun());
			map.put("password", ecoding);

			log.debug("selectLoginServiceImpl sabun    :::" + map.get("sabun"));
			log.debug("selectLoginServiceImpl password :::" + map.get("password"));
			
			vResult = loginMapper.selectLogin(map);
//			vResult = comcmMapper.insertLogin(map);
			log.debug("selectLoginServiceImpl vResult ::: " + vResult);
			return vResult;
		} catch(Exception e){
			
			return -1;
		}
	}
}
