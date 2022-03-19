(ns stock-api.utils
  (:require [cheshire.core :as json]))

(defn parse-json [content & [status]]
  {:status  (or status 200)
   :headers {"Content-Type" "application/json; charset=utf-8"}
   :body    (json/generate-string content)})