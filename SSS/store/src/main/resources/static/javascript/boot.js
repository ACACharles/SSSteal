var app = angular.module('boot',["ngRoute"]);

app.config(
    function($routeProvider){
        
         $routeProvider.when("/",
                                   {templateUrl : "invy.html",
                                    controller : "strap"})
                                    
                            .when("/Contact",
                                   {templateUrl : "Contact.html",
                                    controller : "strap"})
							.when("/nwo",
                                   {templateUrl : "nwo.html",
                                    controller : "strap"})
                            .otherwise({template : "Sorry not content for that option <strong> Keep calm CO</strong>"});
        
        
    });// rnf ngRoute config

app.controller('strap',
            function($scope,$http){
            
            $scope.fn = "first Name please";
            
                        $scope.ln = "L Name please";
                        
                                    $scope.pn = "prefered pronouns?";
                                    
                                                $scope.st = "where u B?";
            
            $http.get("http://localhost:8080/invy").then(
                     function(response){
                        if(response.data)
                            $scope.invy = response.data;
                            console.log("good");
                            console.log(response.data);

                     },
                     function(response){
                         console.log("bad");
                         console.log(response);
                     });
                      
} );//close controller