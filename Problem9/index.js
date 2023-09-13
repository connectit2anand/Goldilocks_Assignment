let obj={
    "anand@gmail.com":"1234",
    "anand1@gmail.com":"1234",
    "anand2@gmail.com":"1234"
}
function validateUser(){
    
    event.preventDefault();
    console.log("hello")
    username=document.getElementById("username").value;
    password=document.getElementById("password").value;
    let fl=true;
    for(let k in obj){
        
        if(k==username){
            if(obj[k]==password){
                document.getElementById("login-message").textContent = "Login successful!";
                fl=false;
            }else{
                document.getElementById("login-message").textContent = "Login Failed!";
            }
        }
    }
    if(fl){
        alert("Wrong username or password")
    }
    

}