(ns portfolio-pie.core
  (:require [portfolio-pie.parsing.vanguard :refer [parse-assets]]
            [portfolio-pie.composition.pie :refer [type-composition]]))

(defn -main [& [filepath]]
  (-> filepath
      parse-assets
      type-composition
      (println)))
