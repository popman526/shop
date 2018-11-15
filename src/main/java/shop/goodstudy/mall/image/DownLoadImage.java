package shop.goodstudy.mall.image;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class DownLoadImage extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		byte[] data = (byte[]) model.get("imagefile");
		OutputStream out = res.getOutputStream();
		InputStream is = new ByteArrayInputStream(data);
		byte[] image = new byte[1024];
		try {
			int temp;
			while ((temp = is.read(image)) >= 0) {
				out.write(image, 0, temp);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		is.close();
		out.close();
	}

}
