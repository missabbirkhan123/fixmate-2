# Deployment Guide for creativepulse.store

Your web project is ready in the `/web` folder. To make it live on Vercel:

## 1. Deploy to Vercel
Run these commands in your terminal:
```bash
cd web
npx vercel --prod
```

## 2. Connect Domain (creativepulse.store)
Go to Vercel Dashboard > Project Settings > Domains and add `creativepulse.store`.

## 3. Update DNS Settings
Log in to your Domain Registrar (e.g., Namecheap/GoDaddy) and set:

| Type  | Name | Value               |
|-------|------|---------------------|
| A     | @    | 76.76.21.21         |
| CNAME | www  | cname.vercel-dns.com|

## 4. Current Web Pages
- Home: https://creativepulse.store/
- Seller: https://creativepulse.store/seller
- Admin: https://creativepulse.store/admin
- Service: https://creativepulse.store/service
