'use strict';
var app = angular.module('videoApp', ['ngRoute', 'ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'templates/login.html',
            controller: 'loginController',
            data : {'title': 'Login'}
        })
        .state('signup', {
            url: '/signup',
            templateUrl : 'templates/signup.html',
            controller: 'signupController',
            data : {'title': 'Sign up'}
        });
    $urlRouterProvider.otherwise('/login');
}).run(function($rootScope, $state){
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
        console.log('from state '+ fromState.name + ' to state ' + toState.name );
    });
});


