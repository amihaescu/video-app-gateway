'use strict';
app.controller('mainController', mainCtrl);

function mainCtrl($scope, $http, $state, sharedScope) {
    $scope.title = "Your series";

    $http.get("/api/movies/list")
        .then(
            function (response) {
                $scope.movies = response.data;
            },
            function () {
            }
        );

    $scope.viewMovie = function(movie){
        console.log("Viewing movie "+movie.id);
        sharedScope.setMovie(movie);
        $state.transitionTo("view");
    }
}
