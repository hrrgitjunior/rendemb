(ns rendemb.backend.plotdata)

(def region-chart
  {:chart {:type "bar"}
   :title {:text "Historic World Population by Region"}
   :subtitle {:text "Source: Wikipedia.org"}
   :xAxis {:categories ["Africa" "America" "Asia" "Europe" "Oceania"]
           :title {:text nil}}
   :yAxis {:min 0
           :title {:text "Population (millions)"
                   :align "high"}
           :labels {:overflow "justify"}}
   :tooltip {:valueSuffix " millions"}
   :plotOptions {:bar {:dataLabels {:enabled true}}}
   :legend {:layout "vertical"
            :align "right"
            :verticalAlign "top"
            :x -40
            :y 100
            :floating true
            :borderWidth 1
            :shadow true}
   :credits {:enabled false}
   :series [{:name "Year 1800"
             :data [107 31 635 203 2]}
            {:name "Year 1900"
             :data [133 156 947 408 6]}
            {:name "Year 2008"
             :data [973 914 4054 732 34]}]})

;
;
(def tcr-plot-data
  ;
  [[{:x 0, :y 0.013869797911853086}
    {:x 1, :y 2.19343140408856E-5}
    {:x 2, :y 0.0024785774866200702}
    {:x 3, :y 0.029845289971631224}
    {:x 4, :y 0.001096715702044276}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 2.339660164361127E-4}
    {:x 9, :y 0}
    {:x 10, :y 0}
    {:x 11, :y 0.0025590033047699842}
    {:x 12, :y 0}
    {:x 13, :y 0}
    {:x 14, :y 0.002390840230456526}
    {:x 15, :y 0}
    {:x 16, :y 0.018900067265229713}
    {:x 17, :y 1.4622876027257E-5}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.01372032408432985}
    {:x 1, :y 8.012556146808877E-5}
    {:x 2, :y 0.0023330678192178826}
    {:x 3, :y 0.03038644086969228}
    {:x 4, :y 0.0013150018617409844}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 2.4980322104757114E-4}
    {:x 9, :y 0}
    {:x 10, :y 0}
    {:x 11, :y 0.0022340891844631846}
    {:x 12, :y 0}
    {:x 13, :y 0}
    {:x 14, :y 0.002564017966978846}
    {:x 15, :y 0}
    {:x 16, :y 0.015864861170681595}
    {:x 17, :y 1.41398049649568E-5}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.017578281092658722}
    {:x 1, :y 4.595367869187861E-5}
    {:x 2, :y 0.002271710116202866}
    {:x 3, :y 0.030367389671211414}
    {:x 4, :y 0.0019480363793296439}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 1.338650640154724E-4}
    {:x 9, :y 5.794159487236863E-5}
    {:x 10, :y 0}
    {:x 11, :y 0.0018401451337052262}
    {:x 12, :y 0}
    {:x 13, :y 5.99395809024503E-6}
    {:x 14, :y 0.0033326406981762347}
    {:x 15, :y 0}
    {:x 16, :y 0.01430957594744495}
    {:x 17, :y 1.19879161804901E-5}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.01615059277277402}
    {:x 1, :y 1.70441955991887E-5}
    {:x 2, :y 0.002106175599042605}
    {:x 3, :y 0.030000219139657884}
    {:x 4, :y 0.0015485869144405732}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 1.290489095367144E-4}
    {:x 9, :y 1.70441955991887E-5}
    {:x 10, :y 0}
    {:x 11, :y 0.0023131408313184667}
    {:x 12, :y 0}
    {:x 13, :y 0}
    {:x 14, :y 0.0031044784841379146}
    {:x 15, :y 0}
    {:x 16, :y 0.015529697075946496}
    {:x 17, :y 0}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.015628881061301024}
    {:x 1, :y 4.107201880707302E-5}
    {:x 2, :y 0.0017582735670266}
    {:x 3, :y 0.03181907971296563}
    {:x 4, :y 0.0015998529230564623}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 2.93371562907664E-5}
    {:x 8, :y 8.801146887229937E-5}
    {:x 9, :y 1.56464833550754E-5}
    {:x 10, :y 0}
    {:x 11, :y 0.0019245174526742773}
    {:x 12, :y 0}
    {:x 13, :y 0}
    {:x 14, :y 0.003598691171667395}
    {:x 15, :y 1.17348625163066E-5}
    {:x 16, :y 0.016577449114702325}
    {:x 17, :y 7.43207959366083E-5}
    {:x 18, :y 9.77905209692214E-6}
    {:x 19, :y 0}]
   [{:x 0, :y 0.015737631911001335}
    {:x 1, :y 1.746442714495907E-5}
    {:x 2, :y 0.002145941485436851}
    {:x 3, :y 0.02966332950571336}
    {:x 4, :y 0.0016962324864541476}
    {:x 5, :y 4.36610678623978E-6}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 1.2880015019407347E-4}
    {:x 9, :y 3.056274750367846E-5}
    {:x 10, :y 3.71119076830381E-5}
    {:x 11, :y 0.0019669311072010188}
    {:x 12, :y 0}
    {:x 13, :y 3.711190768303807E-5}
    {:x 14, :y 0.0031588782598444476}
    {:x 15, :y 0}
    {:x 16, :y 0.015388343368102096}
    {:x 17, :y 0}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.016476691509571574}
    {:x 1, :y 5.76847643000531E-6}
    {:x 2, :y 0.0019324396040517784}
    {:x 3, :y 0.030272964304667655}
    {:x 4, :y 0.001701700546851565}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 6.53760662067268E-5}
    {:x 9, :y 1.53826038133475E-5}
    {:x 10, :y 0}
    {:x 11, :y 0.002024735226931863}
    {:x 12, :y 0}
    {:x 13, :y 3.84565095333687E-6}
    {:x 14, :y 0.0039860172131337135}
    {:x 15, :y 1.730542929001592E-5}
    {:x 16, :y 0.015221086473307268}
    {:x 17, :y 7.691301906673747E-5}
    {:x 18, :y 5.76847643000531E-6}
    {:x 19, :y 3.84565095333687E-6}]
   [{:x 0, :y 0.016084886717638216}
    {:x 1, :y 3.89889388380516E-5}
    {:x 2, :y 0.0023295890955735876}
    {:x 3, :y 0.030269062666921392}
    {:x 4, :y 0.0017096649680485689}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 1.6180409617791436E-4}
    {:x 9, :y 7.79778776761033E-6}
    {:x 10, :y 0}
    {:x 11, :y 0.002278903475084117}
    {:x 12, :y 3.89889388380516E-6}
    {:x 13, :y 0}
    {:x 14, :y 0.0038287137938966403}
    {:x 15, :y 0}
    {:x 16, :y 0.01572423903338622}
    {:x 17, :y 2.92417041285387E-5}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.01540750136401158}
    {:x 1, :y 7.228095373552635E-5}
    {:x 2, :y 0.0023363069562257217}
    {:x 3, :y 0.031069151887932047}
    {:x 4, :y 0.0015179000284460602}
    {:x 5, :y 0}
    {:x 6, :y 0}
    {:x 7, :y 0}
    {:x 8, :y 9.792903409329369E-5}
    {:x 9, :y 3.963794237109508E-5}
    {:x 10, :y 0}
    {:x 11, :y 0.0020751628653102715}
    {:x 12, :y 0}
    {:x 13, :y 6.99493100666384E-6}
    {:x 14, :y 0.0033808833198875152}
    {:x 15, :y 0}
    {:x 16, :y 0.01572460490298034}
    {:x 17, :y 9.32657467555178E-6}
    {:x 18, :y 0}
    {:x 19, :y 0}]
   [{:x 0, :y 0.01691774183335995}
    {:x 1, :y 5.6010948922885074E-5}
    {:x 2, :y 0.001936030625812765}
    {:x 3, :y 0.03137587243141067}
    {:x 4, :y 0.0015512597592990346}
    {:x 5, :y 0}
    {:x 6, :y 7.30577594646327E-6}
    {:x 7, :y 0}
    {:x 8, :y 6.08814662205273E-5}
    {:x 9, :y 2.922310378585305E-5}
    {:x 10, :y 0}
    {:x 11, :y 0.002347589337463534}
    {:x 12, :y 0}
    {:x 13, :y 0}
    {:x 14, :y 0.003141483656979226}
    {:x 15, :y 0}
    {:x 16, :y 0.01613115328979088}
    {:x 17, :y 4.87051729764219E-5}
    {:x 18, :y 2.191732783938978E-5}
    {:x 19, :y 0}]])

;
(def genes
  ["IGHV01-03" "IGHV03-25" "IGHV03-72" "IGHV01-18" "IGHV03-13" "IGHV03-or16_12" "IGHV03-16" "IGHV_III-47_1" "IGHV03-21" "IGHV03-76" "IGHV07-NL1" "IGHV03-71" "IGHV_II-44_2" "IGHV03-09" "IGHV03-64" "IGHV01-or15_03" "IGHV03-53" "IGHV03-11" "IGHV04-04" "IGHV_II-74_1" "IGHV04-55" "IGHV03-15" "IGHV07-40" "IGHV03-48" "IGHV_II-28_1" "IGHV03-43" "IGHV03-33" "IGHV01-68" "IGHV07-27" "IGHV04-28" "IGHV03-or16_07_1" "IGHV03-49" "IGHV01-17" "IGHV03-47" "IGHV03-41" "IGHV03-74" "IGHV03-d" "IGHV06-01" "IGHV03-19" "IGHV03-or16_08" "IGHV01-45" "IGHV07-04_1" "IGHV04-b" "IGHV04-31" "IGHV01-08" "IGHV04-39" "IGHV04-59" "IGHV04-34" "IGHV03-65" "IGHV03-73" "IGHV_II-30_1" "IGHV04-61" "IGHV07-56" "IGHV_II-62_1" "IGHV03-or16_06" "IGHV01-or15_01" "IGHV03-35" "IGHV04-or15_8" "IGHV02-or16_05" "IGHV01-24" "IGHV03-66" "IGHV03-22" "IGHV05-a" "IGHV01-46" "IGHV01-67" "IGHV_II-53_1" "IGHV_III-02_1" "IGHV01-or15_02" "IGHV_II-33_1" "IGHV03-52" "IGHV_III-05_2" "IGHV03-23" "IGHV_II-65_1" "IGHV_II-15_1" "IGHV02-26" "IGHV_III-38_1" "IGHV03-or16_09" "IGHV01-02" "IGHV01-58" "IGHV03-30" "IGHV01-69" "IGHV05-51" "IGHV02-05" "IGHV02-70" "IGHV01-14" "IGHV03-38" "IGHV01-c" "IGHV04-30_2" "IGHV_IV-44_1" "IGHV07-81" "IGHV03-20"])

(def histogram-chart
  {:chart {:type "column"}
   :title {:text "Histrogram"}
   :subtitle {:text "Source: Wikipedia.org"}
   :xAxis {:categories genes
           :title {:text nil}}
   :yAxis {:min 0
           :title {:text "Sum Frequensy"
                   :align "high"}
           :labels {:overflow "justify"}}
   :tooltip {:valueSuffix " millions"}
   :plotOptions {:bar {:dataLabels {:enabled true}}}
   :legend {:layout "vertical"
            :align "right"
            :verticalAlign "top"
            :x -40
            :y 100
            :floating true
            :borderWidth 1
            :shadow true
            :symbolRadius 0}

   :credits {:enabled false}
   :series
   (map-indexed
     (fn [idx sample-data]
       { :name (str "Sample- " idx)
      :borderWidth 0 ;default 1
      :pointPadding 0 ;default 0.1
      :groupPadding 0 ;default 0.2
      :data sample-data
      :type "column"})
     tcr-plot-data)})


;
(def line-chart
  {:chart {:type "line"}
   :title {:text "Test line"}
   :series [{:name "Line 1"
             :color "red"
             :dashStyle "Solid"
             :data [{:x 1 :y 1} {:x 2 :y 2}]}

            ;
            {:name "Line 2"
             :color "blue"
             :dashStyle "Solid"
             :data [{:x 1 :y 2} {:x 2 :y 3}]}]})
;
(def heatmap-chart
  {:chart {:type "heatmap"}
   :title {:text "Test heatmap"}

   :xAxis {:categories ["BM1" "BM2"]
           :title {:text nil}}
   :yAxis {:categories ["SUBJ1" "SUBJ2"]
           :title {:text nil}}

   :colorAxis {:min 0
               :max 100}


   :series [{:type "heatmap"
             :borderWidth 1
             :data
             [[0 0 10] [1 0 20] [0 1 0] [1 1 1]]
             :dataLabels {:enabled true}}]})

