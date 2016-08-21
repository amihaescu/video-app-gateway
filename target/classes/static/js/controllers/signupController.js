'use strict';
app.controller('signupController',function($scope, $http, $state){
    $scope.title = 'Sign up';
    $scope.credentials = {"username":"", "password":""};

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
