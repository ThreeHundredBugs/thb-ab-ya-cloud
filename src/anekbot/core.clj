(ns anekbot.core
  (:require [clojure.edn :as edn]
            [org.httpkit.client :as c]
            [telegrambot-lib.core :as tbot]
            [cheshire.core :refer [parse-string]])
  (:import [javax.servlet.http HttpServlet HttpServletRequest HttpServletResponse])
  (:gen-class
    :name    anekbot.AnekCore
    :extends HttpServlet
    :methods [[doGet [HttpServletRequest HttpServletResponse] void]]))

(defonce env (atom nil))

(defonce update-id (atom nil))

(defn get-bot [] (tbot/create (:token @env)))

(defn set-id!
  "Sets the update id to process next as the the passed in `id`."
  [id]
  (reset! update-id id))

(defn poll-updates
  "Long poll for recent chat messages from Telegram."
  ([bot]
   (poll-updates bot nil))

  ([bot offset]
   (let [resp (tbot/get-updates bot {:offset  offset
                                     :timeout (:timeout @env)})]
     (if (contains? resp :error)
       (println "tbot/get-updates error:" (:error resp))
       resp))))

(defn vulgar? []
  (let [is-vulgar (rand-int 2)]
    (if (= is-vulgar 0)
      "1"
      "11")))

(defn get-anek []
  (let [resp-body (-> (str "http://rzhunemogu.ru/RandJSON.aspx?CType=" (vulgar?))
                      c/get
                      deref
                      :body)
        _         (println "anek-body" resp-body)
        anek      (subs resp-body 12 (- (count resp-body) 2))]
    anek))

(defn step []
  (let [updates  (poll-updates (get-bot) @update-id)

        messages (:result updates)]

    (doseq [msg  messages
            :let [chat-id    (-> msg
                                 :message
                                 :chat
                                 :id)
                  text       (-> msg
                                 :message
                                 :text
                                 str
                                 clojure.string/lower-case)
                  message-id (-> msg
                                 :message
                                 :message_id)]]

      (cond
        (clojure.string/starts-with? text "анек!")
        (tbot/send-message (get-bot) {:chat_id chat-id :text (get-anek)})

        (clojure.string/includes? text "пошел нахуй")
        (tbot/send-message (get-bot) {:chat_id chat-id :text "Сам пошел нахуй, ублюдок" :reply_to_message_id message-id})

        (clojure.string/includes? text "пошла нахуй")
        (tbot/send-message (get-bot) {:chat_id chat-id :text "Сама пошла нахуй, шмонь" :reply_to_message_id message-id})

        (clojure.string/includes? text "пошло нахуй")
        (tbot/send-message (get-bot) {:chat_id chat-id :text "Само пошло нахуй, чудище" :reply_to_message_id message-id})

        (clojure.string/includes? text "пошли нахуй")
        (tbot/send-message (get-bot) {:chat_id chat-id :text "Сами пошли нахуй, выхухоли" :reply_to_message_id message-id}))

      (-> msg
          :update_id
          inc
          set-id!))))

(defn start []
  (loop []
    (step)
    (Thread/sleep (:timeout @env))
    (recur)))

(defn -doGet [request response] (step))

(defn -main [args]

  (reset! env (edn/read-string
             (if args
               args
               (slurp ".env"))))

  (start))

(comment

  (def args nil)

  (start)

  (step)



  (get-bot)

  (get-anek)

  (subs "{\"content\":\"Учитель задал сочинение на тему: \"Если бы я был директором
фирмы...\"
Все старательно пишут, и только Вовочка смотрит в окно.
- А ты почему не пишешь?
- Ожидаю секретаршу!\"}" 12 (- (count "{\"content\":\"Учитель задал сочинение на тему: \"Если бы я был директором
фирмы...\"
Все старательно пишут, и только Вовочка смотрит в окно.
- А ты почему не пишешь?
- Ожидаю секретаршу!\"}") 2))

  (tbot/get-me get-bot)

  )
