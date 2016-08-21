'use strict';
var app = angular.module('videoApp', ['ngRoute', 'ngMaterial', 'ui.router']);

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
        })
        .state('main',{
            url:'/main',
            templateUrl : 'templates/main.html',
            controller: 'mainController'
        });
    $urlRouterProvider.otherwise('/login');
}).run(function($rootScope, $state, AuthService){
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
        console.log('from state '+ fromState.name + ' to state ' + toState.name);
        if (!AuthService.isAuthenticated() && toState.name != "login"){
            console.log("Transitioning to login!!!");
            $state.transitionTo("login");
            event.preventDefault();

        }
    });
});


