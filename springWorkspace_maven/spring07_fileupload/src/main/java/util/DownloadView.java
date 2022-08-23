package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{
 // �ٿ�ε� ������ ����Ʈ Ÿ���� ���� 
 @Override
 public String getContentType() {
  // 8��Ʈ�� �� �Ϸ��� ������..application�� ����Ÿ ������ ���� �������� ������ �����.
  return "application/octet-stream";
 }

 @Override
 protected void renderMergedOutputModel(Map<String, Object> map,
   HttpServletRequest request, HttpServletResponse response) throws Exception {
  
  System.out.println("downloadView ����~~~"+map.get("path"));
  String path=(String)map.get("path");
  String fileName=request.getParameter("filename");
  //���ε� ��ΰ� ����� ���� ��ü
  File file=new File(path+fileName);
  
  // ���� �ٿ�ε� 
    response.setContentType(this.getContentType());
    response.setContentLength((int)file.length());//���� ũ�� ���� 
    // �ٿ�ε� ���Ͽ� ���� ���� 
    response.setHeader("Content-Disposition", 
      "attachment; fileName="
    +new String(file.getName().getBytes("UTF-8"),"8859_1"));
    //������ ���ڵ��� ���̳ʸ� �������� ���
    response.setHeader("Content-Transfer-encoding", "binary");
    // ���� ���ε� ������ inputStream ���� �о 
    // response �� ����� OutputStream���� �����ϰڴ�. 
    OutputStream os=response.getOutputStream();
    FileInputStream fis=new FileInputStream(file);
    FileCopyUtils.copy(fis, os);
    System.out.println("�ٿ�ε�.."+file.getName());
 }
}







