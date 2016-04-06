package com.android.wpf.db;

/**
 * Created by BunnyBlue on 12/17/15.
 */
public class OrderInfoHelper {
//    public static boolean insertNewOrder(AllServiceDrivers baseOrder) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(OrderTable.ORDER_ID, baseOrder.getOrderId());
//        contentValues.put(OrderTable.TS, baseOrder.getSubmitDate());
//        contentValues.put(OrderTable.takeType, baseOrder.getTakeType());
//        contentValues.put(OrderTable.productType, baseOrder.getProductType());
//        contentValues.put(OrderTable.carId, baseOrder.getCarId());
////        "\"ts\" TEXT," +
////                "\"x\" TEXT," +
////                "\"y\" TEXT," +
////                "\"productType\" TEXT," +
////                "\"carId\" TEXT," +
////                "\"takeType\" TEXT," +
////                "\"obj\" blob);";
////        }
//        Uri uri = MyApplication.getContext().getContentResolver().insert(AppContentProvider.CONTENT_URI, contentValues);
//        return uri != null;
//    }
//
//    public static boolean deleteOrder(String orderId) {
//
//
//        int ret = MyApplication.getContext().getContentResolver().delete(AppContentProvider.CONTENT_URI, OrderTable.ORDER_ID + "=?", new String[]{orderId});
//        return ret == 1;
//    }
//
//    public static ArrayList<AllServiceDrivers> getAllOrders() {
//        ArrayList<AllServiceDrivers> orders = new ArrayList<AllServiceDrivers>();
//        Cursor cursor = MyApp.getInstance().getContentResolver().query(AppContentProvider.CONTENT_URI, null, null, null, null);
//        while (cursor.moveToNext()) {
//            AllServiceDrivers baseOrder = new AllServiceDrivers();
//            baseOrder.setOrderId(cursor.getString(1));
//            baseOrder.setDateTS(cursor.getString(2));
//            baseOrder.setProductType(cursor.getString(5));
//            baseOrder.setCarId(cursor.getString(6));
//            baseOrder.setTakeType(cursor.getString(7));
//            orders.add(baseOrder);
////            "\"orderId\" TEXT UNIQUE," +
////                    "\"ts\" TEXT," +
////                    "\"x\" TEXT," +
////                    "\"y\" TEXT," +
////                    "\"productType\" TEXT," +
////                    "\"carId\" TEXT," +
////                    "\"takeType\" TEXT," +
////                    "\"obj\" blob);";
//        }
//        if (cursor != null) {
//            cursor.close();
//        }
//        return orders;
//    }
//
//    public static AllServiceDrivers getOrderById(String id) {
//        AllServiceDrivers order = null;
//        Cursor cursor = MyApp.getInstance().getContentResolver().query(AppContentProvider.CONTENT_URI, null, OrderTable.ORDER_ID + "=?", new String[]{id}, null);
//        while (cursor.moveToNext()) {
//            AllServiceDrivers baseOrder = new AllServiceDrivers();
//            baseOrder.setOrderId(cursor.getString(1));
//            baseOrder.setDateTS(cursor.getString(2));
//            baseOrder.setProductType(cursor.getString(5));
//            baseOrder.setCarId(cursor.getString(6));
//            baseOrder.setTakeType(cursor.getString(7));
//            order = baseOrder;
//            break;
//            // orders.add(baseOrder);
////            "\"orderId\" TEXT UNIQUE," +
////                    "\"ts\" TEXT," +
////                    "\"x\" TEXT," +
////                    "\"y\" TEXT," +
////                    "\"productType\" TEXT," +
////                    "\"carId\" TEXT," +
////                    "\"takeType\" TEXT," +
////                    "\"obj\" blob);";
//        }
//        if (cursor != null) {
//            cursor.close();
//        }
//        return order;
//    }
}
