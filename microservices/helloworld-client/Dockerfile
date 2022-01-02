FROM node:16-alpine AS ui-build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN npm install @angular/cli && npm install && npm run build

FROM node:16-alpine AS server-build
WORKDIR /root/
COPY --from=ui-build /usr/src/app/dist ./app/dist
COPY package*.json ./
RUN npm install
COPY server.js .

EXPOSE 4200

CMD ["node", "server.js"]
