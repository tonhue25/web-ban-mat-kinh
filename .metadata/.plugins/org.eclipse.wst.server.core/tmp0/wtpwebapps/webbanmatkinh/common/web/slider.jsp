 <div id="slides-shop" class="cover-slides">
        <ul class="slides-container">
         <c:forEach var="item" items="${sliders}" varStatus="index">                
            <li class="text-center">
                <img src="<c:url value='/template/image/${item.image}'/>" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>Welcome To <br> PandaShop</strong></h1>
                            <p class="m-b-40">${item.caption} <br>${item.content}</p>
                            <p><a class="btn hvr-hover" href="<c:url value='/san-pham/danh-sach?page=1&limit=6'/>">Shop Now</a></p>
                        </div>
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>
        <div class="slides-navigation">
            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
        </div>
    </div>
