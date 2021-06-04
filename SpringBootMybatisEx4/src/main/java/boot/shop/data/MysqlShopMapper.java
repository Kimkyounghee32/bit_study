package boot.shop.data;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MysqlShopMapper {
	public int getTotalCount();
	public void insertShop(ShopDto dto); //메서드 이름이 아이디가 된다.
	public List<ShopDto> getAllDatas();
	public ShopDto getData(Long num);
}
