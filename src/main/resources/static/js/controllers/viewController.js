app.controller('viewController', function ($scope, $sce, $http, sharedScope) {
    $scope.movie = sharedScope.getMovie();
    $scope.comments = [
        /*{id: 1, user: 'Mike', text: 'Awesome episode'},
         {id: 2, user: 'John', text: 'I didn\'t like this episode'}*/
    ];
    $scope.comment = {id: '', userName: sessionStorage.hash, movieId: $scope.movie.id, text: ''};


    $scope.trustSrc = function (src) {
        return $sce.trustAsResourceUrl(src);
    };

    $scope.addComment = function () {
        $http.post("/api/comments/add", $scope.comment)
            .success(function (data) {
                $scope.getComments();
                $scope.comment.text = "";
            })
    };

    $scope.getComments = function () {
        $http.get("/api/comments/" + $scope.movie.id)
            .success(function (response) {
                $scope.comments = response;
            })
    };
    $scope.getComments();
});