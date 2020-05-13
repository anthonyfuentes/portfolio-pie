(ns portfolio-pie.reporting.composition
  (:require [portfolio-pie.composition.pie :as composition]
            [portfolio-pie.output.writer :refer [append write]]))

(defn summarize [assets output-file]
  (write output-file (pr-str (composition/by-type assets)))
  (append output-file (pr-str (composition/by-asset assets))))
