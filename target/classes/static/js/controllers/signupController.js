'use strict';
app.controller('signupController',function($scope, $http, $state){
    $scope.title = 'Sign up';
    $scope.credentials = {username:"", password:"", accountType: '', subscriptionType: ''};
    $scope.accountTypes = [{name : 'Free', value : 0}, {name : 'Premium', value : 1}];
    $scope.subscriptionTypes = [{name: 'Monthly', value : 0}, {name : 'Quarterly', value : 1}, {name : 'Yearly', value: 2}];

    $scope.showSubscription = function(){
        return $scope.credentials.accountType == 1;
    }

    $scope.signup = function ($stateProvider) {
        console.log($scope.credentials.username + " - "+ $scope.credentials.password);
        $http.post("/api/user/signup", $scope.credentials)
            .then(
                function(response){
                    if (response.data.response){
                        window.sessionStorage.hash = response.data.response;
                        $state.go("main");
                    }
                },
                function (response) {

                }
            );
    }
});
