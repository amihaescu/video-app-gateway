'use strict';
var app = angular.module('videoApp', ['ngRoute', 'ngMaterial', 'ngSanitize', 'ui.router']);

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
        })
        .state('unauthorized', {
            url : '/unauthorized',
            templateUrl : 'templates/unauthorized.html'
        })
        .state('view', {
            url : '/view',
            templateUrl : 'templates/view.html',
            controller : 'viewController'
        });
    $urlRouterProvider.otherwise('/login');
}).run(function($rootScope, $state, AuthService){
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
        console.log('from state '+ fromState.name + ' to state ' + toState.name);
        if (toState.name == "login" || toState.name == "signup"){

        } else if (!AuthService.isAuthenticated() && toState.name != "unauthorized") {
                $state.transitionTo("unauthorized");
                event.preventDefault();
        }
    });
});


