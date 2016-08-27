app.controller('viewController', function($scope, $sce, sharedScope){
    $scope.movie = sharedScope.getMovie();
    console.log("Viewing movie "+ sharedScope.getMovie());

    $scope.trustSrc = function(src){
        return $sce.trustAsResourceUrl(src);
    };
});