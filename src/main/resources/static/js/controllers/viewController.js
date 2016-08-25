app.controller('viewController', function($scope, sharedScope){
    $scope.movie = sharedScope.getMovie();
    console.log("Viewing movie "+ sharedScope.getMovie());
});