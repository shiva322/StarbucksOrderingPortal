'use strict';

var orders = angular.module('myApp.orders', ['ngRoute']);


orders.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/orders', {
    templateUrl: 'orders/orders.html',
    controller: 'ordersCtrl'
  });
}])

    .service('sharedOrder', function () {
        var order123="";
        return {
            getOrderProperty: function () {
                return order123;
            },
            setOrderProperty: function(value) {
                order123 = value.toString();
            }
        };
    })


.controller('ordersCtrl', ['$scope','$http','$window','sharedProperties','sharedOrder',function($scope,$http,$window,sharedProperties,sharedOrder) {

    $scope.init = function () {
        $scope.showAllItems();
        //alert(sharedProperties.getProperty());
        //alert()
    }

    $scope.setOrder = function (value) {
        sharedProperties.setOrderProperty(value);
//        alert(value);
    };

    $scope.showAllItems =  function () {

        $http({
            method: 'GET',
            url: sharedProperties.getURL()+'/'+sharedProperties.getProperty()+'/starbucks/orders'
        }).then(function successCallback(response) {
                 //       alert("cart received");


            $scope.order = response.data;
        }, function errorCallback(response) {
//            alert("Fail"+sharedProperties.getProperty());
        });
    };


}]);

