package shop.goodstudy.mall.order.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.coobird.thumbnailator.Thumbnails;
import shop.goodstudy.mall.cart.mapper.CartMapper;
import shop.goodstudy.mall.image.mapper.ImageMapper;
import shop.goodstudy.mall.image.model.Thumbnail;
import shop.goodstudy.mall.image.service.ImageService;
import shop.goodstudy.mall.order.mapper.CouponMapper;
import shop.goodstudy.mall.order.mapper.OrderMapper;
import shop.goodstudy.mall.order.model.CouponVO;
import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;
import shop.goodstudy.mall.order.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;
	@Autowired
	CouponMapper couponMapper;
	
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private ImageService imageService;
	@Autowired CartMapper cartMapper;
	
	public int insertOrder(OrderVO order) throws Exception {
		return orderMapper.insertOrder(order);
	}
	
	public int insertOrderDetail(OrderDetailVO order) throws Exception {
		return orderMapper.insertOrderDetail(order);
	}
	
	public int insertOrderAndDetail(OrderVO order, OrderDetailVO orderDetail) throws Exception {
		
		// 썸네일 저장 S
		int product_id = orderDetail.getProduct_id();
		
		// 해당 썸네일 존재유무 확인 ( T: pass, F: 썸네일 신규저장 )
		int countThumb = imageMapper.countThumbnail(product_id);
		
		if( countThumb == 0 ) {
			byte[] imageInByte = imageMapper.downloadMainImage(product_id).getImagefile();
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bufferedImage = ImageIO.read(in);
			
			try{
				BufferedImage thumbnail = Thumbnails.of(bufferedImage)
													.size(150, 150)
													.asBufferedImage();
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write( thumbnail, "jpg", baos );
				baos.flush();
				byte[] imageForSave = baos.toByteArray();
				baos.close();
				
				Thumbnail thumb = new Thumbnail();
				thumb.setThumbfile(imageForSave);
				thumb.setProduct_id(product_id);
				imageService.insertThumbnail(thumb);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		// 썸네일 저장 E
		
		int rv = orderMapper.insertOrder(order);
		orderDetail.setOrder_id(order.getOrder_id());
		rv = orderMapper.insertOrderDetail(orderDetail);
		return rv;
	}

	public int deleteOrder(int order_id) throws Exception {
		return orderMapper.deleteOrder(order_id);
	}
	
	public int deleteOrderDetail(int order_id) throws Exception {
		return orderMapper.deleteOrderDetail(order_id);
	}
	
	public int deleteOrderAndDetail(int order_id) throws Exception {
		int rv = 0;
		rv = orderMapper.deleteOrder(order_id);
		rv = orderMapper.deleteOrderDetail(order_id);
		return rv;
	}
	
	public int insertCoupon(CouponVO coupon) throws Exception {
		return couponMapper.insertCoupon(coupon);
	}
	
	public boolean addOrder(OrderVO order, List<OrderDetailVO> list) throws Exception{
		
		boolean result = orderMapper.insertOrder(order) > 0;
		result = orderMapper.insertOrderDetails(list) == list.size();
		
		return result;
		
	}
	
	public boolean insertCartOrder(OrderVO order, List<Long> list) throws Exception {
		
		boolean result = orderMapper.insertOrder(order) > 0;
		orderMapper.insertCartOrder(list);
		cartMapper.deleteOrdered(list);
		return result;
		
	}
	
}
