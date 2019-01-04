package shop.goodstudy.mall.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class DownLoadImageUtils extends AbstractView {
	
	public static final String DELETE_LEGACY_FILES = "DELETE_LEGACY_FILES";
	public static final String NOT_DELETE_LEGACY_FILES = "NOT_DELETE_LEGACY_FILES";

	/**
	 * 이미지: 상품 이미지 다운로드를 위한 메서드
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest req, HttpServletResponse res) throws IOException {
		byte[] data = (byte[]) model.get("imagefile");
		OutputStream out = res.getOutputStream();
		InputStream is = new ByteArrayInputStream(data);
		byte[] image = new byte[1024];
		int temp;
		while ((temp = is.read(image)) >= 0) {
			out.write(image, 0, temp);
			out.flush();
		}
		is.close();
		out.close();
	}

}
