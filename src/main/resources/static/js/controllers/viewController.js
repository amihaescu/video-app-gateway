app.controller('viewController', function($scope, $sce, sharedScope){
    $scope.movie = sharedScope.getMovie();
    $scope.comments = [
        {id: 1, user: 'Mike', text: 'Awesome episode'},
        {id: 2, user: 'John', text: 'I didn\'t like this episode'}
    ];
    $scope.comment = {id: 3, user : 'Jeannie', text: ''};

    $scope.trustSrc = function(src){
        return $sce.trustAsResourceUrl(src);
    };

    $scope.addComment = function(){
        $scope.comments.push($scope.comment);
    }
});