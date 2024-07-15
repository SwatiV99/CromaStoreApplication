package Constants;

public class ShortPath {
    public static final String SHIP_NODE = "D001";
    public static final String ORDER_NUMBER = "TEST20240715";
    public static final String SHIPMENT_NO = "107833357";
    public static final String PIN_CODE = "400069";
    public static final String CITY = "MUMBAI";
    public static final String PORT = "http://10.34.32.94:9080/wsc/store/login.do";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "//div[@class='form-group']//input[@id='password']";
    public static final String LOGIN = "//*[@id=\"loginBtn\"]";
    public static final String CONTINUE_PACKING = "//span[@isc-i18n='shipmentsummary.ACTION_ContinuePackShipment']";
    public static final String ORDER_NUMBER_FOR_RTS = "pick_shipmentOrderBarcodeScanner";
    public static final String SEARCH_ORDER_NUMBER_FOR_RTS = "//button[@title='Scan or enter order or shipment #']";
    public static final String CLICK_ON_PICK_ORDER_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/button/span[2]";
    public static final String PICK_OK_BUTTON = "//*[@id=\"bodyTagId\"]/div[1]/div/div/footer/div/button";
    public static final String FINISH_PICK_BUTTON = "//span[normalize-space()='Finish Pick']";
    public static final String BACK_BUTTON = "//*[@id=\"goBack\"]/span[1]";
    public static final String VIEW_ALL_SHIPMENT_BUTTON = "//*[text()='View All Shipments']";
    public static final String FILTER_BUTTON = "//*[@id=\"filterBtn\"]/span[1]";
    public static final String FILTER_BUTTON1 = "//*[@id=\"filterBtn\"]/span[1]";
    public static final String CLICK_ON_ORDER_NUMBER_IN_FILTER = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[2]/div[1]/div/isc-view-all-shipments-filter/div/div[1]/div/div[2]/div/div/section/uib-accordion/div/div[4]/div[1]/h4/a/span/span[2]";
    public static final String TYPE_ORDER_NUMBER = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[2]/div[1]/div/isc-view-all-shipments-filter/div/div[1]/div/div[2]/div/div/section/uib-accordion/div/div[4]/div[2]/div/div/input";
   // public static final String APPLY_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[2]/div[1]/div/isc-view-all-shipments-filter/div/div[1]/div/div[2]/div/div/div/div/button[2]";
    public static final String APPLY_BUTTON = "//button[@type='submit']";
    public static final String CLICK_ON_SHIPMENT_NUMBER = "//*[@id=\"list-item_0\"]/div[2]/a/span";
    public static final String UPDATE_CARRIER_AND_VOLUMETRICS_BUTTON = "//button[normalize-space()='Update carrier & volumetrics']";
    public static final String UPDATE_CARRIER_AND_VOLUMETRICS_OK_BUTTON = "//*[@id=\"okBtn\"]";
    public static final String FINISH_PACKING_BUTTON = "//span[normalize-space()='Finish Pack']";
    public static final String PRINT_AWB_BUTTON = "//span[normalize-space()='Print AWB']";
    public static final String PRINT_INVOICE_BUTTON = "//span[normalize-space()='Print Invoice']";
    public static final String CONNECT_TO_CARRIER_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[1]/div[2]/div/div[3]/button";
    public static final String CONNECT_TO_CARRIER_OK_BUTTON = "//*[@id=\"bodyTagId\"]/div[1]/div/div/footer/div/button";
    public static final String CLICK_ON_DONE_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[1]/div[2]/div/div[3]/button/span[2]";
    public static final String ORDER_CHANNEL_EXPAND = "//span[@class='grp-hdr-txt'][normalize-space()='Order Channel']";
    public static final String ORDER_CHANNEL_DROPDOWN = "//select[@id='order_channel']";
    public static final String ORDER_CHANNEL_VALUE = "//*[text()='All']";
    public static final String ORDER_TYPE_EXPAND = "//span[@class='grp-hdr-txt'][normalize-space()='Order Type']";
    public static final String ORDER_TYPE_DROPDOWN = "//div[@class='panel-collapse in collapse']//select[@id='lp_mode']";
    public static final String ORDER_TYPE_VALUE = "//*[text()='Sales']";
    public static final String SHIPMENT_NUMBER_EXPAND = "//div[@is-open='ui.accordianConfig.showShipmentNo']//span[@title='Expand']";
    public static final String TYPE_SHIPMENT_NUMBER = "//input[@ng-model='ui.filterCriteria.shipmentNo']";
    public static final String STATUS_EXPAND = "//span[@class='grp-hdr-txt'][normalize-space()='Status']";

    public static final String STATUS_DROPDOWN = "//div[5]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//select[1]";
    public static final String STATUS_VALUE = "//*[text()='Connect To Carrier']";
    public static final String CARRIER_EXPAND = "//span[@class='grp-hdr-txt'][normalize-space()='Carrier']";
    public static final String CARRIER_DROPDOWN = "//select[@id='shipment_carrier']";
    public static final String CARRIER_VALUE = "//*[text()='Delhivery']";
    public static final String ORDER_DATE_EXPAND = "//span[contains(text(),'Order Date')]";
    public static final String CLICK_ORDER_DATE_FROM = "//input[@id='from_date_orderListDateFilter']";
    public static final String SELECT_DATE_FROM = "//span[normalize-space()='01']";
    public static final String SELECT_DATE_TO = "//span[normalize-space()='15']";
    public static final String CLICK_ORDER_DATE_TO = "//input[@id='to_date_orderListDateFilter']";
    public static final String ESTIMATED_DELIVERY_DATE_EXPAND = "//span[contains(text(),'Estimated Delivery Date')]";
    public static final String ESTIMATED_DELIVERY_DATE_FROM = "//input[@id='from_date_orderListEDDFilter']";
    public static final String ESTIMATED_DELIVERY_DATE_TO = "//input[@id='to_date_orderListEDDFilter']";
    public static final String DELIVERY_FROM_DATE = "//span[normalize-space()='01']";
    public static final String DELIVERY_TO_DATE = "//span[normalize-space()='15']";
    public static final String PIN_CODE_EXPAND = "//span[contains(text(),'Pin Code')]";
    public static final String TYPE_PIN_CODE = "//input[contains(@ng-model,'ui.filterCriteria.pinCode')]";
    public static final String CITY_EXPAND = "//span[contains(text(),'City')]";
    public static final String TYPE_CITY = "//input[contains(@ng-model,'ui.filterCriteria.city')]";
    public static final String LP_MODE_EXPAND = "//span[contains(@class,'grp-hdr-txt')][normalize-space()='LP Mode']";
    public static final String LP_MODE_DROPDOWN = "//div[contains(@class,'panel-collapse in collapse')]//select[@id='lp_mode']";
    public static final String LP_MODE_VALUE = "//*[text()='DELHIVERY_EXPRESS-PREPAID']";
    public static final String SELECT_CHECK_BOX = "//input[@id='addressCheck_$index']";
    public static final String HANDOVER_SHIPMENTS_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[1]/div[2]/div/div[2]/button/span";
    public static final String HANDOVER_SHIPMENTS_OK_BUTTON = "//*[@id=\"bodyTagId\"]/div[1]/div/div/footer/div/button/span";
    public static final String DELIVERY_IN_PROGRESS_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[1]/div[2]/div/div[4]/button/span";
    public static final String DELIVERY_IN_PROGRESS_OK_BUTTON = "//*[@id=\"bodyTagId\"]/div[1]/div/div/footer/div/button";
    public static final String OUT_FOR_DELIVER_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[1]/div[2]/div/div[3]/button/span";
    public static final String OUT_FOR_DELIVERY_OK_BUTTON = "//*[@id=\"bodyTagId\"]/div[1]/div/div/footer/div/button/span";
    public static final String DELIVERED_BUTTON = "//*[@id=\"mainContentHolder\"]/div[2]/div/div/div[1]/div[2]/div/div[3]/button/span";
    public static final String DELIVERED_OK_BUTTON = "//*[@id=\"bodyTagId\"]/div[1]/div/div/footer/div/button";
    public static final String CLICK_ON_HOTC = "//*[text()='HOTC']";
    public static final String CLICK_ON_DIP = "//*[text()='DIP']";
    public static final String CLICK_ON_OUT_FOR_DELIVERY = "//*[text()='Out For Delivery']";
//    public static final String TYPE_PIN_CODE = "";







}
