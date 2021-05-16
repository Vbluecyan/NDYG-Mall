package com.bluecyan.mapper;

import com.bluecyan.pojo.Clothing;
import com.bluecyan.pojo.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author bluecyan
 * @DateTime 2021-04-16 23:29
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ClothingExtendMapperTest {

    @Autowired
    ClothingExtendMapper clothingExtendMapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() throws InterruptedException {
        Clothing clothing = new Clothing();

        String[] title = {"男士皮衣春秋季修身韩版帅气皮夹克外套男装青年机车服潮","三叶草 男装运动外套GN3469 GN3473 GN3475",
                "春季新款男士时尚纯色上衣青年潮流黑色外套男装","春季新款男士时尚纯色上衣青年潮流黑色外套男装",
                "商场同款gxgjeans男装2020夏新款针织休闲长裤男基础束脚运动裤潮","情侣装 高弹力运动拉链连帽开衫",
                "夹克外套男春秋薄款男士运动风衣立领休闲青年春装上衣服潮","官方风衣男2021春秋新款韩版潮流帅气大衣夹克休闲男士外套黑",
                "官方风衣男2021春秋新款韩版潮流帅气大衣夹克休闲男士外套黑","汉服外套男改良古装服装汉代三国皇帝王爷古代服装话剧影视演出服",
                "黑色西装外套女韩版气质2021春秋装新款炸街小西服职业套装","春夏新品青春女装灯笼袖围腰宝藏连衣裙",
                "欧洲站女装2021年新款欧货潮白色t恤女短袖纯棉宽松打底衫体恤夏","中长款格子西装外套女英伦风2021新款春秋韩版女士休闲百搭小西服",
                "夕洛茜古装汉服女中国风夏季仙气超仙襦裙仙女飘逸古风改良连衣裙","卫衣女士薄款欧洲站春季爆款2021年欧货新款高端气质短款连帽上衣",
                "2021春季小个子西装外套女气质时尚薄小西服套装女夏职业洋气春秋","春夏层次感假两件红色气质时尚蕾丝连衣裙",
                "翻领运动装女夏跑步2021新款宽松洋气短袖长裤休闲套装纯棉两件套","运动休闲套装女夏2021年夏装新款气质减龄时尚女装夏季夏天两件套"};
        // 尺码比较特殊，为了能够区分XL XXL这种，开头也得加,
        String[] size = {",S,M,",",XS,S,M,",",S,L,XL,XXL,",",XS,S,M,L,XL,XXL,",",XS,XXL,",",XL,",",XS,M,XL,",",S,M,L,"};
        String[] texture = {"聚酯纤维","氨纶","纯棉","粘纤","丝绸","呢绒","皮革","涤纶","山羊绒","腈纶"};
        String[] thickness = {"薄","适中","厚","加厚"};
        String[] elastic = {"无弹","微弹","高弹"};
        String[] color = {"多色","蓝色","黑色","灰色","白色","粉红色","金属色","绿色","红色","橙色","大地色","酒红","黄色","紫色","动物","天蓝色","棕色","咖啡色"};
        String[] season= {"四季","春季","夏季","秋季","冬季"};
        String[] picture = {
                "assets/clothing_picture/clothing1.jpg,assets/clothing_picture/clothing2.jpg,assets/clothing_picture/clothing3.jpg,",
                "assets/clothing_picture/gfn1.jpg,assets/clothing_picture/gfn2.jpg,assets/clothing_picture/gfn3.jpg,assets/clothing_picture/gfn4.jpg,assets/clothing_picture/gfn5.jpg,",
                "assets/clothing_picture/xfn1.jpg,assets/clothing_picture/xfn2.jpg,assets/clothing_picture/xfn3.jpg,assets/clothing_picture/xfn4.jpg,assets/clothing_picture/xfn5.jpg,",
                "assets/clothing_picture/hfn1.jpg,assets/clothing_picture/hfn2.jpg,assets/clothing_picture/hfn3.jpg,",
                "assets/clothing_picture/tt1.jpg,assets/clothing_picture/tt2.jpg,assets/clothing_picture/tt3.jpg,assets/clothing_picture/tt4.jpg,assets/clothing_picture/tt5.jpg,",
                "assets/clothing_picture/xfna1.jpg,assets/clothing_picture/xfna2.jpg,assets/clothing_picture/xfna3.jpg,assets/clothing_picture/xfna4.jpg,assets/clothing_picture/xfna5.jpg,"
        };

        for (int i = 0; i < 10; i++) {
            clothing.setClothingId(String.valueOf(System.currentTimeMillis()));
            clothing.setDate(new Date());
            clothing.setInventory(new Random().nextInt(8999)+100);
            clothing.setTitle(title[new Random().nextInt(1000)%title.length]);
            clothing.setPicture(picture[new Random().nextInt(1000)%picture.length]);
            clothing.setPrice(new Random().nextInt(400)+20);
            clothing.setSex(new Random().nextInt(1000)%2 == 0 ? "男" : "女");
            clothing.setSize(size[new Random().nextInt(1000)%size.length]);
            clothing.setBrandId(new Random().nextInt(1000)%7+1);
            clothing.setCategoryId(new Random().nextInt(1000)%16+1);
            clothing.setStyleId(new Random().nextInt(1000)%10+1);
            clothing.setTexture(texture[new Random().nextInt(1000)%texture.length]);
            clothing.setThickness(thickness[new Random().nextInt(1000)%thickness.length]);
            clothing.setElastic(elastic[new Random().nextInt(1000)%elastic.length]);
            clothing.setColour(color[new Random().nextInt(1000)%color.length]);
            clothing.setSeason(season[new Random().nextInt(1000)%season.length]);
            clothing.setSales(new Random().nextInt(9999));
            clothing.setSource((byte) (new Random().nextInt(1000)%2));

//            Thread.sleep(10);

            clothingExtendMapper.insertSelective(clothing);
        }
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {

    }

    @Test
    public void updateByExample() {


    }

    @Test
    public void updateByPrimaryKeySelective() {
        List<Clothing> clothingList = clothingExtendMapper.selectByExample(null);
        for (Clothing clothing : clothingList) {
            clothing.setSize(","+clothing.getSize());
            clothingExtendMapper.updateByPrimaryKeySelective(clothing);
        }
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void getClothingListBySearch() {
        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setKeyword("2021");
        searchCondition.setBrands(new int[]{1,2});
        searchCondition.setCategorys(new int[]{2,3});
        searchCondition.setStyles(new int[]{1,3,4,9});
        searchCondition.setSexs(new String[] {"女"});
        searchCondition.setSizes("A|XXL");
        searchCondition.setOrder("sales DESC");

        List<Clothing> clothingListBySearch = clothingExtendMapper.getClothingListBySearch(searchCondition);
        for (Clothing clothingWithList : clothingListBySearch) {
            System.out.println(clothingWithList.getClothingId());
            System.out.println(clothingWithList.getDate());
            System.out.println(clothingWithList.getInventory());
            System.out.println(clothingWithList.getPrice());
            System.out.println(clothingWithList.getBrandId());
            System.out.println(clothingWithList.getCategoryId());
            System.out.println(clothingWithList.getStyleId());
            System.out.println(clothingWithList.getSex());
            System.out.println(clothingWithList.getPrice());
            System.out.println(clothingWithList.getPicture());
            System.out.println(clothingWithList.getSales());
            System.out.println(clothingWithList.getBrand().getBrandName());
            System.out.println(clothingWithList.getCategory().getCategoryName());
            System.out.println(clothingWithList.getStyle().getStyleName());
            System.out.println("===============================");
        }
    }

    @Test
    public void getAll() {
        Clothing clothing= clothingExtendMapper.getAll("1619191290881");
        System.out.println(clothing.getBrand().getBrandName());
        System.out.println(clothing.getCategory().getCategoryName());
        System.out.println(clothing.getStyle().getStyleName());
    }
}