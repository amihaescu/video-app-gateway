app.controller('loginController', function($scope, $http, $state){
    $scope.title = 'Login';
    $scope.credentials = {"username":"", "password":""};

    $scope.login = function(){
        $http.post("/api/user/login", $scope.credentials)
            .then(
                function(response){
                    if (response.data.response){
                        window.sessionStorage.hash = response.data.response;
                        $state.go('main');
                    }
                },
                function (response) {

                }
            );
    }
});
