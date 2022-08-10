<%-- 
    Document   : test
    Created on : Jun 4, 2022, 2:23:13 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Star Rating Form</title>
        <link rel="stylesheet" href="feedbackStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    </head>
    <body>
        <form action="MainController" method="POST">
            <div class="container">
                <div class="post">
                    <div class="text">Thanks for rating us!</div>
                    <!--                <div class="edit">EDIT</div>-->
                </div>

                <div class="star-widget">
                    <input type="radio" name="rate" id="rate-5" value="5">
                    <label for="rate-5" class="fas fa-star" ></label>
                    <input type="radio" name="rate" id="rate-4" value="4">
                    <label for="rate-4" class="fas fa-star"></label>
                    <input type="radio" name="rate" id="rate-3" value="3">
                    <label for="rate-3" class="fas fa-star"></label>
                    <input type="radio" name="rate" id="rate-2" value="2">
                    <label for="rate-2" class="fas fa-star"></label>
                    <input type="radio" name="rate" id="rate-1" value="1">
                    <label for="rate-1" class="fas fa-star"></label>
                    <header></header>
                    <div class="textarea">
                        <textarea cols="30" name="cusID" placeholder="CusID..."></textarea>
                    </div>
                    <div class="textarea">
                        <textarea cols="30" name="infoFeedback" placeholder="Describe your experience.."></textarea>
                    </div>
                    <div class="btn">
                        <button type="submit" name="action" value="AddFeedback1">Post</button>
                    </div>
                </div>
            </div>
        </form>




        <script>
            const btn = document.querySelector("button");
            const post = document.querySelector(".post");
            const widget = document.querySelector(".star-widget");
            const editBtn = document.querySelector(".edit");
            btn.onclick = () => {
                widget.style.display = "none";
                post.style.display = "block";
                //                editBtn.onclick = () => {
                //                    widget.style.display = "block";
                //                    post.style.display = "none";
                //                }
                //                return false;
            }
        </script>
    </body>
</html>
