package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
//单文件上传
//动作类作为模型
public class UploadAction extends ActionSupport {
	private String name;
	private File train_file;//必须是File类型，名字对应表单的上传输入域
	private String train_fileFileName;//上传文件的文件名。XXXFileName固定写法
	private String train_fileContentType;//上传文件的MIME类型。XXXContentType固定写法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getTrain_file() {
		return train_file;
	}
	public void setTrain_file(File trainFile) {
		train_file = trainFile;
	}

	public String getTrain_fileFileName() {
		return train_fileFileName;
	}

	public void setTrain_fileFileName(String trainFileFileName) {
		train_fileFileName = trainFileFileName;
	}

	public String getTrain_fileContentType() {
		return train_fileContentType;
	}

	public void setTrain_fileContentType(String trainFileContentType) {
		train_fileContentType = trainFileContentType;
	}


	public String upload() throws Exception{
		
		System.out.println(name);
		
		//完成上传
		ServletContext sc = ServletActionContext.getServletContext();
		String directory = sc.getRealPath("/files");//得到存放文件的真实目录
		//构建目标文件
		File target = new File(directory, train_fileFileName);
		//写文件
		FileUtils.copyFile(train_file, target);
		return SUCCESS;
	}
	
	
	
}
