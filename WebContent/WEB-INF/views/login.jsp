<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/carSharing/html/css/login.css" media="screen" />
<jsp:include page="/theme/html/header.html" />

<body>
<div class="banner-wrapper">
		<img class="banner" alt="Banner"
			src="/carSharing/html/img/header.jpg">
</div>
	<div class="login-area">
        <div class="bg-image">
            <div class="login-signup">
                <div class="container">
                    <div class="tab-content">
                        <div id="login" class="tab-pane">
                           <div class="login-inner">
                                <div class="title">
                                    <h1>Willkommen <span>zurück!</span></h1>
                                </div>
                                <div class="login-form">
                                    <form method="post" action="login">
                                        <div class="form-details">
                                            <label class="user">
                                                <input type="text" name="username" placeholder="Username" id="username">
                                            </label>
                                            <label class="mail">
                                                <input type="password" name="pass" placeholder="Passwort" id="pass">
                                            </label>
                                        </div>
                                        <button type="submit" value="login" onsubmit="">Anmelden</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="/theme/html/footer.html" />

</html>