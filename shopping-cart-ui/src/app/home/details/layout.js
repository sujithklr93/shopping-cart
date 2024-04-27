import { Inter } from "next/font/google";
import RelatedProducts from "./relatedItems";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Create Next App",
  description: "Generated by create next app",
};

export default function RootLayout({ children }) {
  return (
    <>
        {children}
        <RelatedProducts />
        </>
  );
}