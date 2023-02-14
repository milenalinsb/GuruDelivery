FROM node:lts-alpine
WORKDIR "/app/"
ADD "application/package.json" "/app/"
ADD "application/package-lock.json" "/app/"
RUN ["npm", "i"]
ADD "application/src/" "/app/src"
ADD "application/tailwind.config.js" "/app/tailwind.config.js"
ADD "application/public/" "/app/public"
CMD ["npm", "run","start"]