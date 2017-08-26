'use strict';

angular.module('myApp.confirm', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/confirm', {
            templateUrl: 'confirm/confirm.html',
            controller: 'confirmCtrl'
        });
    }])