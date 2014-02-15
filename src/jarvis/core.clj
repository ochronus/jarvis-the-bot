(ns jarvis.core
  (:require [xmpp :as xmpp]))

(defn fetch-url [address]
  (with-open [stream (.openStream (java.net.URL. address))]
    (let  [buf (java.io.BufferedReader.
                (java.io.InputStreamReader. stream))]
      (apply str (line-seq buf)))))

(defn handle-message [message]
  (let [body (:body message)
        from-user (:from-name message)]
    (println "ffff")
    (if (clojure.string/blank? body) (fetch-url "http://api.sharedcount.com/?url=http://ochronus.com/") (str "Hi " from-user ", you sent me '" body "'"))))



(defn start-bot [] (xmpp/start-bot :username "12694_642587@chat.hipchat.com"
                :password "Pazuzu666"
                :host "chat.hipchat.com"
                :domain "chat.hipchat.com"
                :handler (var handle-message)
                )
)

