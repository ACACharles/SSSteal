var app = angular.module('gray',[]);

        app.controller('scale1',
            function($scope,$http){
            
            $http.get("/invy").then(
                     function(response){
                        if(response.data)
                            $scope.iNames = response.data;
                            console.log("good 2");
                            console.log(response);

                     },
                     function(response){
                         console.log("bad 2");
                         console.log(response);
                     });
            
            
            });// end scale1
            
            
        app.controller('scale2',
            function($scope,$http){
     
        }); //  end scale2
            
            
        app.controller('scalefor',
            function($scope,$http){
            $scope.CID = 2;
            $scope.viewNWO = true;
                   
            $scope.addCust = function(){
            var URL= "/Customer";

            URL +=  "?fn="+$scope.fn +
                    "&ln="+$scope.ln +
                    "&pn="+$scope.pn +
                    "&street="+$scope.street +
                    "&city="+$scope.city +
                    "&state="+$scope.state +
                    "&zip="+$scope.zip;
                
            $http.post(URL).then(
                     function(response){
                        if(response.data)
                            $scope.iNames = response.data;
                            $scope.CID = response.data.clientID;
                            console.log("good 2");
                            console.log($scope.iNames);

                     },
                     function(response){
                         console.log("bad 2");
                         console.log(response);
                     });//http
                     
          
             $scope.viewNWO = $scope.hideCustForm = true;
            };//addCust
            
            $scope.showPrompt = function(){
            
            var qrds = prompt("Please give a Name for the Order. ", "Order Juan");
              
            if(qrds == null)
            	return;
            	
            console.log(qrds);
            
            var URL = "/Order";
            
            URL += "?CID="+$scope.CID
                 + "&oName="+qrds;
            $scope.viewNWO = false;
            
             $http.post(URL).then(
                     function(response){
                        if(response.data)
                            $scope.orderSon = response.data;
                            console.log("good-");
                            console.log(response);

                     },
                     function(response){
                         console.log("bad-");
                         console.log(response);
                     });//http
           	
            
            };//ShowPrompt
            
            }); // end scalefor