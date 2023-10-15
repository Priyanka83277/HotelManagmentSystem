<%
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Daily Food</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="css/index-styles.css">
</head>
<body id="page-top">
	<div class="main">
        <div class="menu">
              <h1>FOOD MENU</h1>
            <h1>Add Item</h1>
            <form action="HotelMenu" method="post">
                <label for="foods">Choose a food:</label>
                <select name="foods" id="foods">
                    <optgroup label="Breakfast">
                        <option value="omlet">Omlet <span name="price">30</span></option>
                        <option value="salad">Salad <span >10</span></option>
                        <option value="sandwitch">Sandwitch <span>20</span></option>
                        <option value="dosa">Dosa <span>30</span></option>
                    </optgroup>
                    <optgroup label="Lunch">
                        <option value="chikenberiyani">Chiken Beriyani <span>130</span></option>
                        <option value="mottoncurry">Motton Curry <span>150</span></option>
                    </optgroup>
                    <optgroup label="Dinner">
                        <option value="pizza">Pizza <span>100</span></option>
                        <option value="dalroti">Dal roti <span>40</span></option>
                    </optgroup>
                </select>
                
                
                <br>
                <label for="foods">Choose Quantity:</label>
                <input type="text" name="quantity">
                <br><br>
               <label for=name>Entre Your Name:</label>
                <input type="text" name="user_name">
                <br>
                <label for="foods">Enter Phone Number:</label>
                <input type="text" name="user_phone">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </div>

    </div>
</body>
</html>
