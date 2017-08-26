'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'Home/home.html',
    controller: 'homeCtrl'
  });
}])


.service('sharedProperties', function () {
    var store = '';
    var order = '';
    //var url = ""
    var url = "https://ec2-52-53-182-241.us-west-1.compute.amazonaws.com:8000"
    return {
        getProperty: function () {
            return store;
        },
        setProperty: function(value) {
            store = value;
        },
        getOrderProperty: function () {
            return order;
        },
        setOrderProperty: function(orderIn) {
            order = orderIn;
        },
        getURL: function() {
            return url;
        }
    };
})
    .controller('homeCtrl', ['$scope','sharedProperties',function($scope,sharedProperties) {

        $scope.setStore = function (value) {
            sharedProperties.setProperty(value);
        //    alert(value);
        };

    }]);
