function createClusterDendrogram(data, svgContainer){
 var
  d3Plot = {svg: null,
            svgGroup: null,
            zoom:null,
            viewerWidth: null,
            viewerHeight: null
          }
  svgContainer = {nativeElement: svgContainer}
  d3.select(svgContainer.nativeElement).select("svg").remove();
  d3Plot.zoom = d3.zoom();

  radius = 5;
  root = d3.hierarchy(data);
    // Define the layout
  tree = d3.cluster().nodeSize([1.2 * radius * 2, 1.2 * radius * 2]);
    // define the baseSvg, attaching a class for styling and the zoomListener
  d3Plot.svg = d3.select(svgContainer.nativeElement).append("svg")
    .call(d3Plot.zoom);
  console.log("Tree", tree)
  //this.resizeSVG()
  d3Plot.svgGroup = d3Plot.svg.append("g");
  parentElement = svgContainer.nativeElement
  nodes = root.descendants();
  maxBottom = nodes[nodes.length - 1].y;
  minLeft = 0, maxRight = 0;
  maxHeightOffset = 0;
  leafOffset = 50;//maxBottom / 10;
  width = parentElement.clientWidth;
  height = parentElement.clientHeight;
  heightScaleFactor = 1;
  //---------------------------------------------------
  //====== scale  plot to fit height =====
    for (var i = 0; i < nodes.length; i++) {
      if (nodes[i].x < minLeft) {
        minLeft = nodes[i].x
      }

      if (nodes[i].x > maxRight) {
        maxRight = nodes[i].x
      }

      if (!nodes[i].data.leaf) {
        nodes[i].y =  maxBottom - nodes[i].data.height * heightScaleFactor;
        if (nodes[i].data.height > maxHeightOffset) {
           maxHeightOffset = nodes[i].data.height;
        }

      } else {
        nodes[i].y = nodes[i].parent.y + leafOffset;
      }
    }





}

//
//   // define the baseSvg, attaching a class for styling and the zoomListener
//   this.svg = d3.select(self.treeContainer.nativeElement).append("svg")
//     .call(self.zoom);
//   this.resizeSVG()
//
//   // Append a group which holds all nodes and which the zoom Listener can act upon.
//   this.svgGroup = this.svg.append("g");
//
//   var nodes = root.descendants();
//   var maxBottom = nodes[nodes.length - 1].y;
//   var minLeft = 0, maxRight = 0;
//   var maxHeightOffset = 0;
//   var leafOffset = 50;//maxBottom / 10;
//   var heightScaleFactor = self.viewerHeight / maxHeight // scale  plot to fit height
//
// //====== scale  plot to fit height =====
//   for (var i = 0; i < nodes.length; i++) {
//     if (nodes[i].x < minLeft) {
//       minLeft = nodes[i].x
//     }
//
//     if (nodes[i].x > maxRight) {
//       maxRight = nodes[i].x
//     }
//
//     if (!nodes[i].data.leaf) {
//       nodes[i].y =  maxBottom - nodes[i].data.height * heightScaleFactor;
//       if (nodes[i].data.height > maxHeightOffset) {
//          maxHeightOffset = nodes[i].data.height;
//       }
//
//     } else {
//       nodes[i].y = nodes[i].parent.y + leafOffset;
//     }
//   }
//
//   minLeft = minLeft - radius * 2;
//   maxHeightOffset = Math.round(maxHeightOffset * heightScaleFactor);
//
// //====== scale  plot to fit width =====
//   var widthScaleFactor = self.viewerWidth / (maxRight - minLeft); //scale  plot to fit width
//   if (widthScaleFactor > 1) {
//     for (var i = 0; i < nodes.length; i++) {
//         nodes[i].x = nodes[i].x * widthScaleFactor
//       }
//     minLeft = minLeft * widthScaleFactor
//   }
//
//
// //===== link nodes =====
//   var link = self.svgGroup.selectAll("path.link")
//     .data(root.descendants().slice(1))
//     .enter().append("path")
//     .attr("class", "link")
//     .attr("d", function(d) {
//       return "M" + d.x + "," + d.y
//       + "L" + d.x + ',' + d.parent.y
//       + "L" + d.parent.x + ',' + d.parent.y
//
//     })
//     .attr("stroke", "black")
//     .attr("fill", "none");
//
// //===== range yAxis =====
//   var y = d3.scaleLinear()
//     .domain([0, maxHeight])
//     .range([maxHeightOffset, 0]);
//
//
// //===== add yAxis =====
// //===== IMPORTANT maxBottom is max right position Leafs from CLUSTER() layout =====
// //===== IMPORTANT minLeft is max bottom position Leafs from CLUSTER() layout =====
// //===== There ara right position because cluster create layout horisontal 0 - right =====
// //===== Later we change nodes(x, y) coordinates =====
// //===== bottom yAxis should equal bottom dendrogram =====
//   var yAxis = d3.axisLeft(y)
//   var yAxisGroup = self.svgGroup.append("g")
//     .attr("transform", "translate(" + minLeft + "," +  (maxBottom - maxHeightOffset) + ")")
//     .call(yAxis)
//
//   self.svgGroup.append("text")
//     .attr("transform", "translate(" + (minLeft - plotOptions.offsetYAxisText) + "," + (maxBottom - maxHeightOffset / 2) +") rotate(-90)")
//     .attr("text-anchor", "middle")
//     .text("Height")
//
//
//
// //==========Create tooltip ====================================
//   var div = d3.select(self.treeContainer.nativeElement).append("div")
//       .attr("class", "tooltip")
//       .style("opacity", 0);
// // ---------------------------------------------------------//
//   // Create the nodes
//   var nodeEnter = self.svgGroup.selectAll(".node")
//     .data(root.descendants())
//     .enter().append("g");
//
// //===== Node positioning
//   nodeEnter
//     .attr("class", "node")
//     .attr("transform", function(d) {
//         return "translate(" + d.x + "," + d.y + ")";
//     })
//     .on('click', function(d) {
//     })
//
//     .on("mouseover", function(d) {
//         div.transition()
//                .duration(200)
//                .style("opacity", 1);
//         div.html("<div style = 'padding:10px'>"+
//                     d.data.tooltip +
//                   "</div>")
//                   .style("left", d3.event.layerX + "px")
//                   .style("top", d3.event.layerY + 30 + "px");
//     })
//
//     .on("mousemove", function() {
//         div
//         .style("left", (d3.event.layerX) + "px")
//         .style("top", (d3.event.layerY + 30) + "px");
//     })
//
//     .on("mouseout", function(d) {
//       div.transition()
//           .duration(500)
//           .style("opacity", 0);
//     })
//
//
//
//
//
//   // Create the node ellipse
//   nodeEnter.append("circle")
//     .attr("class", "circle")
//     .attr("r", function(d){
//       if (d.data.leaf) {
//         return radius;
//       } else {
//         return 1;
//       }
//     })
//     .style("fill", function (d){
//       if (d.data.leaf){
//         return d.data.colorFactor
//       }
//     })
//
//
//   nodeEnter.append("text")
//     .attr("x", 0)
//     .attr("dx", function(d){
//       if (!d.data.leaf) {
//         return "5.0em"
//       } else {
//         return plotOptions.offsetLeafText
//       }
//     })
//     .attr("dy", function(d){
//       if (d.data.leaf) {
//         return "0.5em"
//       } else {
//         return "-2.0em"
//       }
//     })
//     .attr('class', 'nodeText')
//     .attr("text-anchor", "middle")
//     .attr("transform", function(d){
//       if (d.data.leaf) {
//         return "rotate(-90)"
//       } else {
//         return "rotate(0)"
//       }
//      })
//     .style("font-size", radius)
//     .style("fill", function(d) {
//       if (d.data.leaf == undefined) {
//         return "black"
//       } else {
//         var rgb = hexToRgb(d.data.colorFactor);
//         var hsl = rgbToHsl(rgb.r, rgb.g, rgb.b);
//         if (hsl[2] <= 0.5 ) {
//           return "black";
//         } else {
//           return "black";
//         }
//       }
//     })
//     .text(function(d) {
//       if (d.data.leaf) {
//         return d.data.name
//       }
//     });
//
//
//   var transf = d3.zoomIdentity.scale(0.1).translate(0, 0);
//   this.svg.call(this.zoom.transform, transf);
//   self.fitScale();
// }
//
//
// onGenerateReport() {
//   this.changeDetector.detectChanges();
//   this.reportModal.requestReportParams = {svg: this.treeContainer.nativeElement.innerHTML};
//   this.reportModal.show();
// }
// }
