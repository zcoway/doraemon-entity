package cn.iocoder.doraemon.itemgroup.item;

import java.util.Date;

public class Item {

    // ========== 基本信息 BEGIN ==========

    /**
     * 商品标题
     *
     * 不能超过100字，受违禁词控制
     */
    private String title;
    /**
     * 副标题，分享链接时显示
     */
    private String summary;
    /**
     * 商品描述。
     *
     * 字数要大于5个字符，小于25000个字符 ，受违禁词控制
     */
    private String desc;
    /**
     * 商品分类的叶子类目编号
     *
     * 有赞——店铺主营类目和商品类目对应表：https://bbs.youzan.com/forum.php?mod=viewthread&tid=25252
     */
    private Integer cid;
    /**
     * 商品主图地址
     *
     * 数组，以逗号分隔
     *
     * 建议尺寸：800*800像素，你可以拖拽图片调整顺序，最多上传15张
     */
    private String picURLs;
    /**
     * 商品类型
     *
     * 0：普通商品（物流发货）
     * 35：酒店商品（无需物流）
     * 60：虚拟商品（无需物流）
     * 61：电子卡券（无需物流）
     */
    private Integer itemType;
    /**
     * todo 芋艿，
     * 分组列表
     */
    private String tag_ids;

    // ========== 基本信息 END ==========

    // ========== 价格库存 BEGIN ==========

    /**
     * 价格，单位分
     */
    private Double price;
    /**
     * todo
     * 商品重量，没有SKU时用
     */
    private Double itemWeight;
    /**
     * 商品货号（商家为商品设置的外部编号）
     */
    private String itemNo;
    /**
     * 总库存
     *
     * 基于 sku 的库存数量累加
     */
    private Integer quantity;
    /**
     * 是否隐藏商品库存。在商品展示时不显示商品的库存。
     *
     * 0 - 显示库存（默认）
     * 1 - 不显示库存
     */
    private Integer hideStock;
    /**
     * 商品划线价格，可以自定义。例如 促销价：888
     *
     * 商品没有优惠的情况下，划线价在商品详情会以划线形式显示。
     */
    private Double originPrice;
    /**
     * todo 芋艿
     * SKU重量带有SKU时用 按如下格式 [ { "s1":1217, "s2":1367, "s3":303435, "weight":100 }, { "s1":1217, "s2":1367, "s3":6356, "weight":100 } ] 并且和SKU对应
     */
    private String sku_weight;
    /**
     * todo 芋艿，
     * sku 的JSON字符串，传入一定要按照这个格式[ { "price":10000, "quantity":100, "item_no":"MOYU-1", "skus":[ { "k":"颜色", "v":"绿色", }, { "k":"尺寸", "v":"l", }, { "k":"内存", "v":"1024G", } ] }, { "price":10000, "quantity":100, "item_no":"MOYU-2","skus":[ { "k":"颜色", "v":"绿色", }, { "k":"尺寸", "v":"l", }, { "k":"内存", "v":"16G", } ] } ] price是 sku 价格，quantity 是sku 的库存，item_no 是 sku 的商家编码，k 是规格名称，v 是规格值名称 要注意：sku_stocks数量=规格1数量 * 规格2数量 * 规格3数量
     */
    private String sku_stocks;
    /**
     * todo 芋艿，
     * SKU图片，仅支持第一级规格， 参数一定要与sku_stocks参数匹配， 如sku_stocks参数是这样的 [ { "price":10000, "quantity":100, "item_no":"MOYU-1", "skus":[ { "k":"颜色", "v":"绿色", }, { "k":"尺寸", "v":"l", }, { "k":"内存", "v":"1024G", } ] }, { "price":10000, "quantity":100, "item_no":"MOYU-2","skus":[ { "k":"颜色", "v":"绿色", }, { "k":"尺寸", "v":"l", }, { "k":"内存", "v":"16G", } ] } ] 颜色就是第一级规格。它下面的规格只有“绿色”这一项，sku_images应该与之一一对应，如下 [{"v":"绿色","img_url":"www.youzan.com"}] 请务必按此格式传参数，不然校验通不过，无法新增商品
     */
    private String sku_images;
    /**
     * 是否参加会员折扣。
     *
     * 1 - 参加会员折扣（默认）
     * 0 - 不参加会员折扣
     */
    private Integer joinLevelDiscount;

    // ========== 价格库存 END ==========

    // ========== 预售扩展信息BEGIN ========== TODO 芋艿，分离

    /**
     * 发货类型
     *
     * -1 - 有现货，立即发货
     * 0 - xxx 时间开始发货
     * 1 - 付款 n 天后发货。
     */
    private Integer etdType;
    /**
     * 预计发货开始时间, 字符串格式的时间，格式如：2018-01-01
     */
    private Integer etdstartTime;
    /**
     * 预计发货结束时间, 字符串格式的时间，格式如：2018-01-01
     */
    private Integer etdEndTime;
    /**
     * 付款成功 后发货天数, 默认0
     */
    private Integer etdDays;

    // ========== 预售扩展信息BEGIN END ==========

    // ========== 其他信息 BEGIN ==========

    /**
     * 运费，单位分
     */
    private Integer postFee;
    /**
     * 运费模版id
     */
    private Integer deliveryTemplateId;
    /**
     * 是否上架商品。
     *
     * 1 - 上架商品
     * 0 - 不上架商品，放入仓库
     */
    private Integer isDisplay;
    /**
     * 开始出售时间。
     *
     * 没设置则为空
     */
    private Date autoListingTime;



    // ========== 其他信息 END ==========

    /**
     * todo 芋艿，
     * 虚拟信息扩展信息，一定要按如下JSON格式，否则校验不通过 { "item_validity_start":2322222,//虚拟商品有效期开始时间, 1970-01-01 开始的秒数,留空表示长期有效 "item_validity_end":2322222,//虚拟商品有效期结束时间,1970-01-01 开始的秒数,留空表示长期有效 "effective_type":1,//电子凭证生效类型，0 立即生效， 1 自定义推迟时间， 2 隔天生效 "effective_delay_hours":1,//电子凭证自定义推迟时间 "holidays_available":true//节假日是否可用 }
     */
    private String virtualExtra;

    /**
     * todo 芋艿，
     * 允许购买的粉丝标签，用,号分隔
     */
    private String ump_tags;

    /**
     * todo 芋艿，
     * 允许购买的粉丝等级，用逗号分隔
     */
    private String ump_level;
    /**
     * todo 芋艿，
     * 商品页模板
     */
    private Integer template_id;





    /**
     * todo 芋艿，
     * 是否设置商品购买权限

     */
    private Boolean purchase_right;



    /**
     * 预售结束时间, 字符串格式的时间
     * todo 芋艿
     */
    private Date pre_sale_end;

    /**
     * 是否预售
     * todo 芋艿
     */
    private Date pre_sale;


    /**
     * todo 芋艿
     * 商品留言
     */
    private String messages;





    /**
     * todo
     * 酒店扩展信息，按以下格式： { "service_tel_code":"0571",//服务电话区号 "service_tel":"4790043"//服务电话 }
     */
    private String hotel_extra;




    /**
     * todo
     * 每人限购多少件。0代表无限购，默认为0
     */
    private Integer buy_quota;


    // TODO 跳转到其他网站购买
}
