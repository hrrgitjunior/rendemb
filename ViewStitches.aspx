<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage" %>
<%@ Import Namespace="MvcApplication1.Models" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	ViewStitches
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

<div id = "Resume">
   </br>

   <div class = "row">
	   <div class = "col-lg-12" style = "height: auto">
	       <% foreach (EmbDesign e in (IEnumerable)ViewData["EmbProject"]) 
	       {%>
		<div id="Container_3d" style="width:100%;height:55%;background-color:transparent;margin-left:0px;margin-top:50px;">
		     <p class = "text-center" id="Hd1">Бодове на проект за машинна бродерия:<%= e.Name%> </p>
		</div>
	     <%} %>
	    	<div style = "margin-left: 10px">	
		    <button class = "btn btn-primary" id = "stitches_id" onclick = "run_stitches()">Старт</button>
		    <button class = "btn btn-success" id = "Button1"  onclick = "stop_stitches()">Стоп</button>
		</div>
	   </div>


	   <div class="viewStitches" style="margin-top:30px;width: 800px;height:800px;margin-left: auto; margin-right: auto" align = "center">
	    <img id = "loaderid" src = "<%= Url.Content("~/images/Loader.gif")%>"/>
	    <canvas id="canvas1"  width="600" height="600"></canvas>
	   </div>
  </div>
</div>


   <script type="text/javascript">


       var embStitches = [];
       var idEmb = <%=ViewData["IdEmb"] %>


       embTitle = {};
       ax = 0;
       ay = 0;
       prev_ax = ax; prev_ay = ay;
       kx = 0; ky = 0; kz = 0;
       c = null; ctx = null;
       idx = -1;
       interval = 5;
       fl_run = true;

       $(document).ready(function () {
           $.ajax({
               type: "POST",
               url: "/Products/FetchStitches",
               // contentType: "application/json; charset=utf-8",
               data: { idEmb: idEmb }, //!!!!!!!
               dataType: "json",
               success: function (response) {
                   var loaderid = document.getElementById("loaderid")
                   loaderid.style.display = "none";
                   response.forEach(function (emb) {
                       embStitches = response[0];
                       embTitle = response[1];
                       drawEbmStitches();
                       //drawRect();
                       //console.log(emb);
                   });
               },
               failure: function (response) {
                   alert(response.responseText);
               },
               error: function (response) {
                   alert(response.responseText);
               }
           });
       });

    //-----------------------------------
           $(function () {
               $("#fetch_stitches_id").click(function () {
                   $.ajax({
                       type: "POST",
                       url: "/Products/FetchStitches",
                       contentType: "application/json; charset=utf-8",
                       dataType: "json",
                       success: function (response) {
                           response.forEach(function (emb) {
                               embStitches = response[0];
                               embTitle = response[1];
                               drawEbmStitches();
                               //drawRect();
                               //console.log(emb);
                           });
                       },
                       failure: function (response) {
                           alert(response.responseText);
                       },
                       error: function (response) {
                           alert(response.responseText);
                       }
                   });
               });
           });
       function drawRect() {
           c = document.getElementById("canvas1");
           ctx = c.getContext("2d");

           ctx.beginPath();
           ctx.fillStyle = "#fff";
           ctx.fillRect(0, 0, 600, 600);
          /* ctx.lineWidth = "1";
           ctx.strokeStyle = "0aa";
           ctx.rect(10, 10, 590, 590);*/
           ctx.stroke();


       }

       function drawEbmStitches() {
           kx = 400 / embTitle.Sz_x;
           ky = 400 / embTitle.Sz_y;
           kz = kx;
           if (ky < kx) kz = ky;

           c = document.getElementById("canvas1");
           ctx = c.getContext("2d");

           ctx.beginPath();
           ctx.setLineDash([]);
           ctx.fillStyle = "#fff";
           ctx.fillRect(0, 0, 600, 600);
           ctx.lineWidth = "1";
           ctx.strokeStyle = "0aa";
           ctx.rect(0, 0, 600, 600);
           ctx.stroke();

           ax = embTitle.AbsSP.X * kz;
           ay = embTitle.AbsSP.Y * kz;

           ctx.moveTo(100 + ax, 500-ay);
           ctx.stroke();

           embStitches.forEach(function (st) {
               switch (st.cmn) {
                   case 64: break;
                   case 0:
                       {
                          prev_ax = ax; prev_ay = ay;
                          ax += st.rx * kz;
                          ay += st.ry * kz;
                          ctx.beginPath();
                          ctx.setLineDash([]);
                          ctx.moveTo(100 + prev_ax, 500 - prev_ay);
                          ctx.lineTo(100 + ax, 500-ay);
                          ctx.stroke();
                          break;
                      }

                  case 128:
                      {
                          prev_ax = ax; prev_ay = ay;
                          ax += st.rx * kz;
                          ay += st.ry * kz;
                          ctx.beginPath();
                          ctx.setLineDash([2, 15]);
                          ctx.moveTo(100 + prev_ax, 500 - prev_ay);
                          ctx.lineTo(100 + ax, 500-ay);
                          ctx.stroke();
                          break;
                      }

               }
           });
      }

      function slaw_draw_stitches() {
          intervalId =
        setInterval(function () {
            idx++;
            //console.log(idx, interval);
            if ((idx >= embStitches.length) || (!fl_run)) {
                clearInterval(intervalId);
                drawEbmStitches();
            }
            else {
                var st = embStitches[idx];
                switch (st.cmn) {
                    case 64: break;
                    case 0:
                        {
                            prev_ax = ax; prev_ay = ay;
                            ax += st.rx * kz;
                            ay += st.ry * kz;
                            ctx.beginPath();
                            ctx.setLineDash([]);
                            ctx.moveTo(100 + prev_ax, 500 - prev_ay);
                            ctx.lineTo(100 + ax, 500 - ay);
                            ctx.stroke();
                            break;
                        }

                    case 128:
                        {
                            prev_ax = ax; prev_ay = ay;
                            ax += st.rx * kz;
                            ay += st.ry * kz;
                            ctx.beginPath();
                            ctx.setLineDash([2, 15]);
                            ctx.moveTo(100 + prev_ax, 500 - prev_ay);
                            ctx.lineTo(100 + ax, 500 - ay);
                            ctx.stroke();
                            break;
                        }

                }
            }
        }, interval)
      }

      function run_stitches() {
          fl_run = true;
          drawRect();
          idx = 0;
          ax = embTitle.AbsSP.X * kz;
          ay = embTitle.AbsSP.Y * kz;
          ctx.moveTo(ax, 600 - ay);
          ctx.stroke();
          slaw_draw_stitches();
      }


      function stop_stitches() {
          fl_run = false;
      }     
     

 </script>

</asp:Content>



