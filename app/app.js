'use strict';

// Declare app level module which depends on views, and components
var starbucksApp = angular.module('myApp', [
  'ngRoute',
  'myApp.confirm',
  'myApp.store',
  'myApp.home',
  'myApp.orders',
  'myApp.order',
  'myApp.cart',
  'myApp.version'
]);

starbucksApp.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.html5Mode({
      enabled: true,
      requireBase: false
    });

  $routeProvider

      .when('/', {
        templateUrl : 'home/home.html',
          controller : 'homeCtrl'

      }) ;


  $routeProvider.otherwise({redirectTo: '/home'});
}]);
