package boot.shop.data;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("shop")
public class ShopDto {
	private int num;
	private String sangpum;
	private String color;
	private MultipartFile upload; //파일 추가
	private String photo;	//얘는 사진이름 집어넣을거
	private int price;
	private String ipgoday;
	private Timestamp writeday;
}
