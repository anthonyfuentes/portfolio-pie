(ns portfolio-pie.reporting.composition
  (:require [portfolio-pie.composition.pie :refer [by-asset by-type]]
            [portfolio-pie.output.writer :refer [append write]]))

(defn write-summary-header [assets output-file]
 (write output-file (str (pr-str (by-type assets)) "\n")))

(defn generate-body-line [asset-comp]
  (str (format "\n%-7s" (first asset-comp)) (second asset-comp)))

(defn append-body-line [output-file asset-comp]
  (append output-file (generate-body-line asset-comp)))

(defn append-summary-body [assets output-file]
  (doseq [acomp (by-asset assets)]
    (append-body-line output-file acomp)))

(defn summarize [assets output-file]
  (write-summary-header assets output-file)
  (append-summary-body assets output-file))
