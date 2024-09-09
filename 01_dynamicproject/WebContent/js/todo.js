const addBtn = document.querySelector("#add-btn");
const input = document.querySelector("#input");
input.addEventListener("keyup",function(event){
    if(event.keyCode == 13){
            todoAdd();  
    }
});
addBtn.addEventListener("click",function(){
        todoAdd();
});
function todoAdd(){
    const inputValue = input.value;
    if(input.value === ""){
        return;
    }
    const ul = document.createElement("ul");
    const likeLi = document.createElement("li");
    const textLi = document.createElement("li");
    const checkLi = document.createElement("li");
    const likeSpan = document.createElement("span");//<span></span>
    const doneSpan = document.createElement("span");
    const cancelSpan = document.createElement("span");
    likeSpan.classList.add("material-icons");//<span class="material-icons"></span>
    likeSpan.innerText="favorite_border";//<span class="material-icons">favorite_border</span>
    // const likeText = document.createTextNode("favorite_border");
    // likeSpan.appendChild(likeText);
    likeSpan.addEventListener("click",function(){
        const current = likeSpan.innerText;
        if(current==="favorite"){
            likeSpan.innerText = "favorite_border";
        }else{
            likeSpan.innerText = "favorite";
        }
    });
    doneSpan.classList.add("material-icons");//<span class="material-icons"></span>
    doneSpan.classList.add("done");//<span class="material-icons done"></span>
    doneSpan.innerText = "check_circle";//<span class="material-icons done">check-circle</span>
    
    doneSpan.addEventListener("click",function(){
        textLi.style.textDecoration = "line-through";
        doneSpan.remove();
    });
    cancelSpan.classList.add("material-icons");//<span class="material-icons"></span>
    cancelSpan.classList.add("cancel");//<span class="material-icons cancel"></span>
    cancelSpan.innerText = "delete";//<span class="material-icons cancel">delete</span>
    cancelSpan.addEventListener("click",function(){
        ul.remove();
    });
    likeLi.classList.add("like");
    likeLi.appendChild(likeSpan);
    textLi.classList.add("todo-text");
    textLi.innerText=inputValue;
    checkLi.classList.add("check-zone");
    checkLi.appendChild(doneSpan);
    checkLi.appendChild(cancelSpan);
    ul.classList.add("todo");
    ul.appendChild(likeLi);
    ul.appendChild(textLi);
    ul.appendChild(checkLi);
    const listbox = document.querySelector(".list-box");
    listbox.appendChild(ul);
    input.value= "";
}




/*
const donIcon = document.querySelectorAll(".done");
const likeIcon = document.querySelectorAll(".todo>.like>span");
*/
/*
donIcon.forEach(function(item, i){
    item.addEventListener("click",function(){

        const current = likeIcon[i].innerText;  
        if(current === 'favorite_border'){
            likeIcon[i].innerText = "favorite";
        }else{
            likeIcon[i].innerText = "favorite_border";
        }
    });
})

const doneIcon = document.querySelectorAll(".done");
donIcon.forEach(function(item,i){

})
doneIcon.addEventListener("click",function(){
    const todoText = document.querySelector(".todo-text");
    todoText.style.textDecoration = "line-throught";
});

const cancelIcon = document.querySelector(".cancel");
cancelIcon.addEventListener("click",function(){
    const todo = document.querySelector(".todo");
    todo.remove();
});
*/

/*
const addBtn = document.querySelector("#add-btn");
addBtn.addEventListener("click",function(){
    todoAdd();
});

function todoAdd(){
    const input = document.querySelector("#input");
    const inputValue = input.value;

    const ul = document.createElement("ul");

    const likeLi = document.createElement("li");//<li></li>
    const textLi = document.createElement("li");//<li></li>
    const checkLi = document.createElement("li");//<li></li>
    
    const likeSpan = document.createElement("span");//<span></span>
    const doneSpan = document.createElement("span");//<span></span>
    const cancelSpan = document.createElement("span");//<span></span>

    likeSpan.classList.add("material-icons");//<span class="material-icons"></span>
    likeSpan.innerText = "favorite_border";//<span class="material-icons">farovite_border</span>
    //const likeText = document.createTextNode("favorite_border");
    //likeSpan.appendChild(likeText);//<span class="material-icons">farovite_border</span>


    
    likeSpan.addEventListener("click",function(){
        const current =likeSpan.innerText;
        if(current === 'favorite'){
            likeSpan.innerText = "favorite_border";
        }else{
            likeSpan.innerText = "favorite";
        }
    });
    

    doneSpan.classList.add("material-icons");//<span class="material-icons"></span>
    doneSpan.classList.add("done");//<span class="material-icons done"></span>
    doneSpan.innerText = "check_box";//<span class="material-icons done">check_box</span>

    
    doneSpan.addEventListener("click",function(){
        textLi.style.textDecoration ="line-through";
    });
    

    cancelSpan.classList.add("material-icons");//<span class="material-icons"></span>
    cancelSpan.classList.add("cancel");//<span class="material-icons cancel"></span>
    cancelSpan.innerText = "delete_forever";//<span class="material-icons">delete_forever</span>

    
    cancelSpan.addEventListener("click",function(){
        ul.remove();
    });
    

    likeLi.classList.add("like");//<li class="like"></li>
    likeLi.appendChild(likeSpan);//<li class="like"><span class="material-icons">farovite_border</span></li>



    textLi.classList.add("todo-text");//<li class="todo-text"></li>
    textLi.innerText = inputValue;//<li class="todo-text">input태그 입력값</li>

    checkLi.classList.add("check-zone");//<li class="check-zone"></li>
    checkLi.appendChild(doneSpan)//<li class="check-zone">//<span class="material-icons done">check_box</span></li>
    checkLi.appendChild(cancelSpan)//<li class="check-zone">//<span class="material-icons done">check_box</span>//<span class="material-icons">delete_forever</span></li>

    ul.classList.add("todo");//<ul class=todo></ul>

    ul.appendChild(likeLi);//<ul class=todo>//<li class="like"><span class="material-icons">farovite_border</span></li></ul>
    ul.appendChild(textLi);//<ul class=todo>//<li class="like"><span class="material-icons">farovite_border</span></li>//<li class="todo-text">input태그 입력값</li></ul>
    ul.appendChild(checkLi);//<ul class=todo>//<li class="like"><span class="material-icons">farovite_border</span></li>//<li class="todo-text">input태그 입력값</li><li class="check-zone">//<span class="material-icons done">check_box</span>//<span class="material-icons">delete_forever</span></li></ul>

    const listBox = document.querySelector(".list-box");
    listBox.appendChild(ul);
}

*/


