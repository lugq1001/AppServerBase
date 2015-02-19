package com.lugq.app.logic.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lugq.app.network.SBMessage;
import com.lugq.app.network.SBMessageFile;
import com.lugq.app.util.LangUtil;

/**
 * 业务逻辑处理接口
 * @author Luguangqing
 *
 */
public abstract class AppLogicHandler {

	private static Logger logger = LogManager.getLogger(AppLogicHandler.class);
	
	public abstract void process(SBMessage message);
	
	public void logicProcess(SBMessage message) {
		logger.info("接收请求:" + message.getReq_data());
		if (!LangUtil.isEmpty(message.getReq_files())) {
			logger.info("请求包含文件：");
			for (SBMessageFile file : message.getReq_files()) {
				logger.info("文件类型:" + file.getFileType() + " 文件名:" + file.getFileName() + " 文件大小:" + file.getFileSize());
			}
		}
		process(message);
	}
}