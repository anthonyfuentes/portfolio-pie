(ns portfolio-pie.core
  (:require [portfolio-pie.parsing.vanguard :refer [parse-assets]]
            [portfolio-pie.reporting.composition :refer [summarize]]))

(defn -main [& [input-file output-file]]
  (-> input-file
      parse-assets
      (summarize output-file)))
