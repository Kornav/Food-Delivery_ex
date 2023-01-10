
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import SearchMenuView from "./components/SearchMenuView"
import SearchMenuViewDetail from "./components/SearchMenuViewDetail"
import StoreOrderManager from "./components/listers/StoreOrderCards"
import StoreOrderDetail from "./components/listers/StoreOrderDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import SelectMenuView from "./components/SelectMenuView"
import SelectMenuViewDetail from "./components/SelectMenuViewDetail"
import NotificationManager from "./components/listers/NotificationCards"
import NotificationDetail from "./components/listers/NotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/searchMenus',
                name: 'SearchMenuView',
                component: SearchMenuView
            },
            {
                path: '/searchMenus/:id',
                name: 'SearchMenuViewDetail',
                component: SearchMenuViewDetail
            },
            {
                path: '/storeOrders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/storeOrders/:id',
                name: 'StoreOrderDetail',
                component: StoreOrderDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/selectMenus',
                name: 'SelectMenuView',
                component: SelectMenuView
            },
            {
                path: '/selectMenus/:id',
                name: 'SelectMenuViewDetail',
                component: SelectMenuViewDetail
            },
            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },
            {
                path: '/notifications/:id',
                name: 'NotificationDetail',
                component: NotificationDetail
            },



    ]
})
