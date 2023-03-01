class Ajax{
   seturl(url){
    this.url=url;
   }
   setmethod(method){
    this.method=method;
   }
   geturl(){
        return this.url;
   }
   getmethod(){
    return this.method;
   }
   constructor(url,method) {
        this.setmethod(method);
        this.seturl(url);    
   }
    call() {
     var response={};
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        response=JSON.parse(this.responseText);
    }
    console.log(this.geturl());
    xhttp.open(this.getmethod(),this.geturl(), false);
    xhttp.send();
    return response;
  }
}